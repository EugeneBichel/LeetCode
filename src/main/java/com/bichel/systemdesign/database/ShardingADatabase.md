# Sharding a database

## Features:
This is the first part of any system design interview, coming up with the features which the system should support. As an interviewee, you should try to list down all the features you can think of which our system should support. Try to spend around 2 minutes for this section in the interview. You can use the notes section alongside to remember what you wrote.

Q: What is the amount of data that we need to store?
A: Let's assume a few 100 TB.

Q: Will the data keep growing over time? If yes, then at what rate?
A: Yes. At the rate of 1TB per day.

Q: Can we make assumptions about the storage of machines available with me?
A: Let's assume that machines have a RAM of 72G and a hard disk capacity of 10TB.

Q: How many machines do I have to begin with?
A: Let's assume we have 20 machines to begin with. More machines will be available on request if need be.

Q: Are all key value entries independent?
A: Yes. A typical query would ask for value corresponding to a key.

## Estimations:
This is usually the second part of a design interview, coming up with the estimated numbers of how scalable our system should be. Important parameters to remember for this section is the number of queries per second and the data which the system will be required to handle.
Try to spend around 5 minutes for this section in the interview.

Total storage size : 100 TB as estimated earlier
Storage with every machine : 10TB
Q: What is the minimum number of machines required to store the data?
A: Assuming a machine has 10TB of hard disk, we would need minimum of 100TB / 10 TB = 10 machines to store the said data. Do note that this is bare minimum. The actual number might be higher.
In this case, we have 20 machines at our disposal.

Q: How frequently would we need to add machines to our pool ?
A: The data grows at 1TB per day. That means that we generate data that would fill the storage of 1 machine ( 10TB ) in 10 days. Assuming, we want to keep a storage utilization of less than 80%, we would need to add a new machine every 8 days.

## Design Goals:
Latency - Is this problem very latency sensitive (Or in other words, Are requests with high latency and a failing request, equally bad?). For example, search typeahead suggestions are useless if they take more than a second.
Consistency - Does this problem require tight consistency? Or is it okay if things are eventually consistent?
Availability - Does this problem require 100% availability?
There could be more goals depending on the problem. It's possible that all parameters might be important, and some of them might conflict. In that case, you’d need to prioritize one over the other.

## Skeleton of the design:
The next step in most cases is to come up with the barebone design of your system, both in terms of API and the overall workflow of a read and write request. Workflow of read/write request here refers to specifying the important components and how they interact. Try to spend around 5 minutes for this section in the interview.
Important : Try to gather feedback from the interviewer here to indicate if you are headed in the right direction.

Note : In questions like these, the interviewer is looking at how you approach designing a solution. So, saying that I’ll use a distributed file system like HDFS is not a valid response. It's okay to discuss the architecture of HDFS with details around how HDFS handles various scenarios internally.

Q: Can we have a fixed number of shards?
A: One qualification for a shard is that the data within a shard should fit on a single machine completely.
As in our case, the data is growing at a fast pace, if we have a fixed number of shards, data within a shard will keep growing and exceed the 10TB mark we have set per machine. Hence, we cannot have a fixed number of shards. The shards will have to increase with time.

Q: How many shards do we have and how do we distribute the data within the shard?
A: Lets say our number of shards is S. One way to shard is that for every key, we calculate a numeric hash H, and assign the key to the shard corresponding to H % S.
There is one problem here though. As we discussed earlier, the number of shards will have to increase. And when it does, our new number of shard becomes S+1.
As, such H%(S+1) changes for every single key causing us to relocate each and every key in our data store. This is extremely expensive and highly undesirable.

-----

## What is sharding?
Sharding is a method of splitting and storing a single logical dataset in multiple databases. By distributing the data among multiple machines, a cluster of database systems can store larger dataset and handle additional requests. Sharding is necessary if a dataset is too large to be stored in a single database. Moreover, many sharding strategies allow additional machines to be added. Sharding allows a database cluster to scale along with its data and traffic growth.
Sharding is also referred as horizontal partitioning. The distinction of horizontal vs vertical comes from the traditional tabular view of a database. A database can be split vertically — storing different tables & columns in a separate database, or horizontally — storing rows of a same table in multiple database nodes.

### Example of vertical partitioning
fetch_user_data(user_id) -> db[“USER”].fetch(user_id)
fetch_photo(photo_id) ->    db[“PHOTO”].fetch(photo_id)
### Example of horizontal partitioning
fetch_user_data(user_id) -> user_db[user_id % 2].fetch(user_id)

Vertical partitioning is very domain specific. You draw a logical split within your application data, storing them in different databases. It is almost always implemented at the application level — a piece of code routing reads and writes to a designated database.
In contrast, sharding splits a homogeneous type of data into multiple databases. You can see that such an algorithm is easily generalizable. That’s why sharding can be implemented at either the application or database level. In many databases, sharding is a first-class concept, and the database knows how to store and retrieve data within a cluster. Almost all modern databases are natively sharded. Cassandra, HBase, HDFS, and MongoDB are popular distributed databases. Notable examples of non-sharded modern databases are Sqlite, Redis (spec in progress), Memcached, and Zookeeper.

If your application is bound by read performance, you can add caches or database replicas. They provide additional read capacity without heavily modifying your application.
Vertically partition by functionality. Binary blobs tend to occupy large amounts of space and are isolated within your application. Storing files in S3 can reduce storage burden. Other functionalities such as full text search, tagging, and analytics are best done by separate databases.
Not everything may need to be sharded. Often times, only few tables occupy a majority of the disk space. Very little is gained by sharding small tables with hundreds of rows. Focus on the large tables.

Common Definitions
Many databases have their own terminologies. The following terminologies are used throughout to describe different algorithms.
Shard or Partition Key is a portion of primary key which determines how data should be distributed. A partition key allows you to retrieve and modify data efficiently by routing operations to the correct database. Entries with the same partition key are stored in the same node. A logical shard is a collection of data sharing the same partition key. A database node, sometimes referred as a physical shard, contains multiple logical shards.

Case 1 — Algorithmic Sharding
One way to categorize sharding is algorithmic versus dynamic. In algorithmic sharding, the client can determine a given partition’s database without any help. In dynamic sharding, a separate locator service tracks the partitions amongst the nodes.

Case 2— Dynamic Sharding
In dynamic sharding, an external locator service determines the location of entries. It can be implemented in multiple ways. If the cardinality of partition keys is relatively low, the locator can be assigned per individual key. Otherwise, a single locator can address a range of partition keys.

Case 3 — Entity Groups
Previous examples are geared towards key-value operations. However, many databases have more expressive querying and manipulation capabilities. Traditional RDBMS features such as joins, indexes and transactions reduce complexity for an application.
The concept of entity groups is very simple. Store related entities in the same partition to provide additional capabilities within a single partition. Specifically:
Queries within a single physical shard are efficient.
Stronger consistency semantics can be achieved within a shard.

------

Q: Can we think of a better sharding strategy?
Hint: Consistent Hashing.
A: Consistent hashing is ideal for the situation described here. Lets explore consistent hashing here.
Let's say we calculate a 64 bit integer hash for every key and map it to a ring. Lets say we start with X shards. Each shard is assigned a position on the ring as well. Each key maps to the first shard on the ring in clockwise direction.
