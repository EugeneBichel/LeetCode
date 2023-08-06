# Highly Consistent Database

Q: What is the amount of data that we need to store?
Answer: Let's assume a few 100 TB.

Q: Do we need to support updates?
A: Yes.
Q: Can the size of the value for a key increase with updates?
A: Yes. In other words, its possible a sequence of keys could co-exist on one server previously, but with time, they grew to a size where all of them don't fit on a single machine.
Q: Can a value be so big that it does not fit on a single machine?
A: No. Let's assume that there is an upper cap of 1GB to the size of the value.
Q: What would the estimated QPS be for this DB?
A: Let's assume around 100k

Total storage size : 100 TB as estimated earlier
Total estimated QPS : Around 10M

Q: What is the minimum number of machines required to store the data?
A: Assuming a machine has 10TB of hard disk, we would need minimum of 100TB / 10 TB = 10 machines to store the said data. Do note that this is bare minimum. The actual number might be higher if we decide to have replication or more machines incase we need more shards to lower the QPS load on every shard.

Design Goals:
Latency - Is this problem very latency sensitive (Or in other words, Are requests with high latency and a failing request, equally bad?). For example, search typeahead suggestions are useless if they take more than a second.
Consistency - Does this problem require tight consistency? Or is it okay if things are eventually consistent?
Availability - Does this problem require 100% availability?
There could be more goals depending on the problem. It's possible that all parameters might be important, and some of them might conflict. In that case, you’d need to prioritize one over the other.

Q: Is Latency a very important metric for us?
A: No, but it would be good to have a lower latency.
Q: Consistency vs Availability?
A: As the question states, we need tight consistency and partitioning. Going by the CAP theorem ( Nicely explained at http://robertgreiner.com/2014/08/cap-theorem-revisited/), we would need to compromise with availability if we have tight consistency and partitioning. As is the case with any storage system, data loss is not acceptable.

Note : In questions like these, the interviewer is looking at how you approach designing a solution. So, saying that I’ll use a NoSQL DB like HBase is not an ideal answer. It is okay to discuss the architecture of HBase for example with rationale around why some components were designed the way they were.

Q: Is sharding required?
A: Lets look at our earlier estimate about the data to be stored. 100TB of data can’t be stored on a single machine.
Let's say that we somehow have a really beefy machine which can store that amount of data, that machine would have to handle all of the queries ( All of the load ) which could lead to a significant performance hit.
Tip: You could argue that there can be multiple copies of the same machine, but this would not scale in the future. As my data grows, its possible that I might not find a big beefy enough machine to fit my data.
So, the best course of action would be to shard the data and distribute the load amongst multiple machines.

Q: Should the data stored be normalized?
http://www.studytonight.com/dbms/database-normalization.php
Q: Can I shared the data so that all the data required for answering my most frequent queries live on a single machine?
A: Most applications are built to store data for a user ( consider messaging for example. Every user has his / her own mailbox ). As such, if you shard based on every user as a row, its okay to store data in a denormalized fashion so that you won’t have to query information across users. In this case, lets say we go with storing data in denormalized fashion.
A: If the data is normalized, then we need to join across tables and across rows to fetch data. If the data is already sharded across machine, any join across machines is highly undesirable ( High latency, Less indexing support ).
With storing denormalized information however, we would be storing the same fields at more than one place. However, all information related to a row ( or a key ) would be on the same machine. This would lead to lower latency.
However, if the sharding criteria is not chosen properly, it could lead to consistency concerns ( After all, we are storing the same data at multiple places ).

Q: How many machines per shard ? How does a read / write look in every shard?
Q: Can we keep just one copy of data?
A: Since there is only one copy of the data, reading it should be consistent. As long as there are enough shard to ensure a reasonable load on each shard, latency should be acceptable as well. Reads and writes would work exactly how they work with a single DB just that there would be a row -> shard -> machine IP ( Given a row, tell me the shard it belongs to and then given the shard, give me the machine I should be querying / writing to ) resolution layer in between.
There is just one tiny problem with this model. What if the machine in the shard goes down? Our shard will be unavailable ( which is fine as governed by the CAP theorem ). However, what if the machine dies and its hard disk becomes corrupt. We suddenly run into the risk of losing the data which is not acceptable. Imagine losing all your messages because your shard went down and the hard disk got corrupted. That means we definitely need more than one copy of data being written with us.

Q: What problem may arise if we keep multiple copies of data?
A: Let's say we keep 3 copies of data ( The probability of all 3 machines dying and having a corrupted disk is negligible ). Now, the issue is how do we maintain all of the copies in absolute sync ( Consistency, remember? ).
One naive way would be that a write would not succeed unless its written to all 3 copies / machines. That would make our write latency go up significantly apart from making writes very unreliable ( My write fails if it fails on any of the machines ). Let's see if we can make this a bit better.
If we have to allow writes succeeding even if the write has been written on a majority of machines (2 out of 3, let's say), to maintain consistency, its important that there is a master machine which keeps track of this information. This master machine can track which machines have a particular block in each shard. This means that every read will go through this master machine, figure out the machines with the block and query from the required block. The machines which do not have the block can check with this master machine to see which block are not present on it, and catch up to replicate the block on it.

However, now if this master machine dies, our whole shard is unavailable till this machine comes back up. If this machine has a corrupted hard disk, then the unavailability becomes indefinite ( Note that we do not loose data in this case, as total data is the union of data present on 3 nodes ). This is not an ideal design, but we will talk about improvements to it later in this question.

Q: What if the master keeping track of where the blocks are stored dies?
Anwer: To overcome this problem we keep a standby master which in the failover process becomes the acting master and keeps unavilability to minimum. Now, to keep the standby master upto date we can have a shared network file system. When any namespace modification is performed by the Active master, it durably logs a record of the modification to an edit log file stored in the shared directory. The Standby node constantly watches this directory for edits, and when edits occur, the Standby node applies them to its own namespace. In the event of a failover, the Standby will ensure that it has read all of the edits from the shared storage before promoting itself to the Active state. This ensures that the namespace state is fully synchronized before a failover occurs.
A: Going back to our design goals, latency and consistency are our design goals.
A simple way to resolve this is to make sure we only have one machine per shard. Reads and writes would work exactly how they work with a single DB. However, if the machine holding the only copy dies and its hard disk becomes corrupt, we suddenly run into the risk of losing the data which is not acceptable. That means we definitely need more than one copy of data being written with us. Lets say that number is 3. Now, the issue is how do we maintain all of the copies in absolute sync ( Consistency, remember? ).
One naive way would be that a write would not succeed unless its written to all 3 copies / machines. That would make our write latency go up significantly apart from making writes very unreliable ( My write fails if it fails on any of the machines ).
If we have to allow writes succeeding when the write has been written on a majority of machines ( 2 out of 3, lets say ), to maintain consistency, its important that there is a master machine which keeps track of this information. This master machine can track which machines have a particular block in each shard. However, now if this master machine dies, our whole shard is unavailable till this machine comes back up. If this machine has a corrupted hard disk, then the unavailability becomes indefinite.
There are couple of ways to keep unavailability to minimum using a standby master keeping track of master node data through a shared file system(Explained in detail in the last hint).



