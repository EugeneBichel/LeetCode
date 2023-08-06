Cassandra is an open-source Apache project. It was originally developed at Facebook in 2007 for their inbox search feature. The Apache Cassandra architecture is designed to provide scalability, availability, and reliability to store large amounts of data. Cassandra combines the distributed nature of Amazon’s Dynamo which is a key-value store and the data model of Google’s BigTable which is a column-based data store. With Cassandra’s decentralized architecture, there is no single point of failure in a cluster, and its performance can scale linearly with the addition of nodes.

Cassandra is a distributed, decentralized, scalable, and highly available NoSQL database. In terms of CAP theorem, Cassandra is typically classified as an AP (i.e., available and partition tolerant) system which means that availability and partition tolerance are generally considered more important than the consistency. Cassandra can be tuned with replication-factor and consistency levels to meet strong consistency requirements, but this comes with a performance cost. In other words, data can be highly available with low consistency guarantees, or it can be highly consistent with lower availability. Cassandra uses peer-to-peer architecture, with each node connected to all other nodes. Each Cassandra node performs all database operations and can serve client requests without the need for any leader node.

By default, Cassandra is not a strongly consistent database (it is eventually consistent), hence, any application where consistency is not a concern can utilize Cassandra. Though Cassandra can support strong consistency, it comes with a performance impact. Cassandra is optimized for high throughput and faster writes, and can be used for collecting big data for performing real-time analysis. Here are some of its top use cases:

Storing key-value data with high availability - Reddit and Digg use Cassandra as a persistent store for their data. Cassandra’s ability to scale linearly without any downtime makes it very suitable for their growth needs.

Time series data model - Due to its data model and log-structured storage engine, Cassandra benefits from high-performing write operations. This also makes Cassandra well suited for storing and analyzing sequentially captured metrics (i.e., measurements from sensors, application logs, etc.). Such usages take advantage of the fact that columns in a row are determined by the application, not a predefined schema. Each row in a table can contain a different number of columns, and there is no requirement for the column names to match.

Write-heavy applications - Cassandra is especially suited for write-intensive applications such as time-series streaming services, sensor logs, and Internet of Things (IoT) applications.

## Column
Column: A column is a key-value pair and is the most basic unit of data structure.
- Column key: Uniquely identifies a column in a row.
- Column value: Stores one value or a collection of values.

## Row
Row: A row is a container for columns referenced by primary key. Cassandra does not store a column that has a null value; this saves a lot of space.

## Table
Table: A table is a container of rows.

## Keyspace
Keyspace: Keyspace is a container for tables that span over one or more Cassandra nodes.

## Cluster
Cluster: Container of Keyspaces is called a cluster.

## Node
Node: Node refers to a computer system running an instance of Cassandra. A node can be a physical host, a machine instance in the cloud, or even a Docker container.

## NoSQL
NoSQL: Cassandra is a NoSQL database which means we cannot have joins between tables, there are no foreign keys, and while querying, we cannot add any column in the where clause other than the primary key. These constraints should be kept in mind before deciding to use Cassandra.

## Cassandra key
The Primary key uniquely identifies each row of a table. Primary key = Partition key + Clustering key

The partition key decides which node stores the data, and the clustering key decides how the data is stored within a node. Let’s take the example of a table with PRIMARY KEY (city_id, employee_id). This primary key has two parts represented by the two columns:

city_id is the partition key. This means that the data will be partitioned by the city_id field, that is, all rows with the same city_id will reside on the same node.
employee_id is the clustering key. This means that within each node, the data is stored in sorted order according to the employee_id column.

## Clustering key
Clustering keys define how the data is stored within a node. We can have multiple clustering keys; all columns listed after the partition key are called clustering columns. Clustering columns specify the order that the data is arranged on a node.

## Partitioner
Partitioner is the component responsible for determining how data is distributed on the Consistent Hash ring. When Cassandra inserts some data into a cluster, the partitioner performs the first step, which is to apply a hashing algorithm to the partition key. The output of this hashing algorithm determines within which range the data lies and hence, on which node the data will be stored.

By default, Cassandra uses the Murmur3 hashing function. Murmur3 will always produce the same hash for a given partition key. This means that we can always find the node where a specific row is stored. Cassandra does allow custom hashing functions, however, once a cluster is initialized with a particular partitioner, it cannot be changed later. In Cassandra’s default configuration, a token is a 64-bit integer. This gives a possible range for tokens from -2^{63}−2 to 2^{63}-12

All Cassandra nodes learn about the token assignments of other nodes through gossip.
This means any node can handle a request for any other node’s range. The node receiving the request is called the coordinator, and any node can act in this role. If a key does not belong to the coordinator’s range, it forwards the request to the replicas responsible for that range.

## Coordinator node
A client may connect to any node in the cluster to initiate a read or write query. This node is known as the coordinator node. The coordinator identifies the nodes responsible for the data that is being written or read and forwards the queries to them.




