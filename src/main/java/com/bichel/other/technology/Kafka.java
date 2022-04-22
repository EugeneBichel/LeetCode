package com.bichel.other.technology;

public class Kafka {
    /*
    MOM ( Message-oriented middleware )

    A MOM sends messages and ensures that they reach the recipient. MOMs are asynchronous,
    meaning that they do not implement request/reply as is done with synchronous communication
    protocols, they only send messages.

    MOMs have different characteristics such as:
        high reliability
        low latency
        high throughput

    Microservices are decoupled by a MOM. A microservice sends a message to or receives it from the MOM. This means that the sender and the recipient do not know each other, only the communication channel. Service discovery is therefore not necessary. Sender and recipient find each other via the topic or queue through which they exchange messages.
    Load balancing is also easy. If several recipients have registered for the same communication channel, a message can be processed by one of the recipients and the load can be distributed, thereby eliminating the need for a specific infrastructure for load balancing.
    However, a MOM is a complex software that handles all communication. Therefore, the MOM must be highly available and has to offer a high throughput. MOMs are generally very mature products, but ensuring adequate performance under all conditions requires a lot of know-how, for example, concerning the configuration.

    Variants of MOM:
    1. JMS ( Java messaging service ):
        JMS can only be used with Java implementations.
        JMS (Java Messaging Service) is a standardized API for the programming language Java and part of the Java EE standard.
        Well known implementations are Apache ActiveMQ or IBM MQ, which was previously known as IBM MQSeries. However, many more JMS products are available. Java application servers that support the entire Java EE profile – not just the web profile – have to contain a JMS implementation, so that JMS is often anyway available.
    2. AMQP (Advanced Message Queuing Protocol) does not standardize an API, but a network protocol at the level of TCP/IP. This allows for a simpler exchange of the implementation.
        RabbitMQ, Apache ActiveMQ, and Apache Qpid are the best known implementations of the AMQP standard. There are also a lot more implementations.
    3. ZeroMQ
    4. MQTT
        MQTT is a messaging protocol that plays a prominent role for the Internet of Things (IoT)

    The use of a well-known technology reduces risk and effort. The requirements for availability and scalability of MOMs are high. A well-known MOM can help to meet these requirements in a simple way.


    5. technology.Kafka
     */

    /*
    technology.Kafka
    In the area of microservices, technology.Kafka is an interesting option.
    In addition to typical features such as high throughput and low latency,
    technology.Kafka can compensate for the failure of individual servers via replication and
    can scale with a larger number of servers.

    technology.Kafka is able to store an extensive message history.
    Usually, MOMs aim only to deliver messages to recipients.
    The MOM then deletes the message because it has left the MOM’s area of responsibility,
    thus saving resources. However, it also means that approaches such as event sourcing
    (see Events) are possible only if every microservice stores the event history itself.
    technology.Kafka, on the other hand, can save records permanently.
    technology.Kafka can also handle large amounts of data and can be distributed across multiple servers.

    technology.Kafka also has stream-processing capabilities.
    For this, applications receive the data records from technology.Kafka,
    transform them, and send them back to technology.Kafka.

    technology.Kafka offers a separate API for each of the three different tasks of a MOM:
        The producer API serves to send data.
        The consumer API serves to receive data.
        Finally, the streams API serves to transform the data.
        technology.Kafka is written in Java. The APIs can be used with a language-neutral protocol.

    technology.Kafka organizes data in records. This is what other MOMs call “messages”.
    Records contain the transported data as a value. technology.Kafka treats the value as a black box and
    does not interpret the data. In addition, records have a key and a timestamp.
    A record could contain information about a new order or an update to an order.
    The key can then be composed of the identity of the record and information about whether
    the record is an update or a new order for example update42 or neworder42.

    A topic is a named set of records. Producers send records to a topic and consumers receive them from a topic.

    If microservices in an e-commerce system are interested in new orders or want to inform
    other microservices about new orders, they could use a topic called “order.”
    New customers would be another topic which could be called “customer.”

    Topics are divided into partitions. Partitions allow strong guarantees concerning
    the order of records, but also parallel processing.

    When a producer creates a new record, it is appended to a partition.
    Therefore, each record is stored in only one single partition.
    Records are usually assigned to partitions by calculating the hash
    of the key of the record. However, a producer can also implement its own algorithm
    to assign records to a partition.
    For each partition, the order of the records is preserved.
    That means the order in which the records are written to the partition is also the order
    in which consumers read the records. There is no guarantee of order across partitions.
    Therefore, partitions are also a concept for parallel processing:
    reading in a partition is linear. A consumer has to process each record in order.
    Across partitions, processing can be parallel.

    Basically, a partition is just a file to which records are appended.
    Appending data is one of the most efficient operations on a mass storage device.
    Moreover, such operations are very reliable and easy to implement.
    This makes the implementation of technology.Kafka not too complex.
     */

    /*
    For each consumer, technology.Kafka stores the offset for each partition.
    This offset indicates which record in the partition the consumer read and processed last.
    It helps technology.Kafka to ensure that each record is eventually handled.
    When consumers have processed a record, they commit a new offset.
    In this way, technology.Kafka knows at all times which records have been processed by which consumer
    and which records still have to be processed. Of course, consumers can commit records
    before they are actually processed. As a result,
    records that never get processed is a possibility.
     */

    /*
    The consumers poll the data, meaning they fetch new data and process it.
    Polling doesn’t seem to be very elegant. However, in the absence of a push,
    the consumers are protected from too much load when a large number of records
    are being sent and have to be processed. Consumers can decide for themselves
    when they process the records.
    Libraries like Spring technology.Kafka for Java, which is used in the example,
    poll new records in the background. The developer implements methods to handle new records.
    Spring technology.Kafka then calls them. The polling is hidden from the developer.
     */

    /*
    Replication
        Partitions store the data. Because data in one partition is independent of data in the other partitions, partitions can be distributed over servers:

        Each server then processes some partitions. This allows load balancing.
        To handle a larger load, new servers need to be added and some partitions need to be moved to the new server.
        The partitions can also be replicated so that the data is stored on several servers, meaning technology.Kafka can be made fail-safe. If one server crashes or loses its data, other replicas still exist.
        Example #
        The number NN of replicas can be configured. When writing, you can determine how many in-sync replicas must commit changes.
        With N=3N=3 replicas and two in-sync replicas, the cluster remains available even if one of the three replicas fails.
        Even if one server fails, new records can still be written to two replicas. If a replica fails, no data is lost because every write operation must have been successful on at least two replicas.
        Even if a replica is lost, the data must still be stored on at least one additional replica.
        technology.Kafka thus supports some fine tuning regarding the CAP theorem (see Events) by changing the number of replicas and in-sync replicas.
     */

    /*
    Consumer groups
        An event like neworder42 should probably be processed only once by one instance
        of the invoicing microservice. Only one instance of a microservice should receive it,
        ensuring that only one invoice is written for this order. However,
        another instance of a microservice might work on neworder21 in parallel.

        Consumers are organized in consumer groups where each partition sends records
        to exactly one consumer in the consumer group. One consumer can be responsible
        for several partitions.


     */
}
