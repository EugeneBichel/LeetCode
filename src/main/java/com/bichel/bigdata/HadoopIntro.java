package com.bichel.bigdata;

public class HadoopIntro {
    /*
    Hadoop is the software manifestation of Big Data.
    Hadoop is a reliable, distributed, and scalable platform
    for storing and analyzing vast amounts of data.
    The lure of Hadoop is its ability to run on cheap commodity hardware,
    while its competitors may need expensive hardware to do the same job.
    Rather than rely on hardware to deliver high availability,
    Hadoop is designed to detect and handle failures at the application layer.
    In essence, Hadoop delivers a highly available service on top of a cluster of computers,
    each of which may be prone to failures. Other solutions depend
    on the hardware to provide high reliability. More importantly,
    Hadoop is open source. Any company with a skilled team and
    enough determination can run and manage their own deployment of the
    Hadoop stack without paying a dime in license fees. Note the term
    Hadoop is sometimes used to refer to a larger ecosystem of
    Apache projects such as Ambari, HBase, HDFS, Zookeeper, and others.

    The name Hadoop by itself doesn't mean much. Dough Cutting (aka the father of Hadoop)
    inspired from the Google's Map Reduce paper, set out to create an open source,
    distributed data processing platform. He named it after his son's toy elephant, "Hadoop".
    Check out this video with more details about how Hadoop got its name.
    Eventually the project was donated to the Apache Foundation and sparked
    a number of other related projects. Together these projects now make
    for an active Big Data ecosystem.
    Note that Hadoop isn't novel in what it does.
    Before the advent of Hadoop, the high performance computing (HPC) and
    grid computing communities had been doing large scale data processing for years.
    They primarily used APIs such as the Message Passing Interface (MPI).
    Broadly, the HPC approach distributes the work across a cluster of machines.
    Then, they access a shared filesystem, hosted by a storage area network (SAN).
    This setup works well for predominantly compute-intensive jobs;
    it becomes a problem when nodes need to access large data volumes, hundreds
    of gigabytes because the network bandwidth will become the bottleneck and compute
    nodes become idle. This is the inflection point where Hadoop shines.

    The collection of data isn't an end in itself,
    but rather it serves as a means to several possible ends.
    Data is valuable when it can be aggregated, sliced, or diced to extract meaningful patterns,
    insights, or predictions. For example, Netflix may collect information on movies
    watched by a user and the movies watched by users with similar demographics and behavior.
    Then Netflix, can run that information through a recommendation algorithm to make
    effective recommendations. Google's omniscient search bar is a wonder of
    collecting the entirety of the web and then indexing it for speedy retrieval.

    The trend of data generated from humans and machines alike, is likely to continue increasing.
    The mountains of collected data can't be processed with traditional data stores and processing
    techniques. It has given way to a new ecosystem of Big Data technologies.
    Even Artificial Intelligence and Machine Learning benefit from Big Data.
    AI needs data to build upon its intelligence and more data can better train learning algorithms.


    Data Type:
    - Structured data: has some pre-defined organizational property
    making it easily searchable and analyzable. The data is backed by a
    model that dictates the size of each field: its type, length, and
    restrictions on what values it can take on. Data stored in SQL
    databases is structured. Structured data is usually formatted in
    a universally understandable and identifiable manner. In most
    instances, a schema formally specifies structured data.
    When working in any variant of SQL, you are almost always
    dealing with structured data.
    - Unstructured data: is characterized by a lack of organization
    and data model that describes the structure of a single record
    or attributes of any individual fields within the record.
    Videos, audio, blogs, log files, and social-media posts are
    all examples of unstructured data. It is data without any
    conceptual definition or type.
    - Semi-structured data: is a cross between structured and
    unstructured data. Even though there's no explicit data model
    or structure definition, one may be implied. Semi-structured
    data contains semantic tags but does not conform to the
    structure associated with typical relational databases.
    Examples include JSON and XML data. It sits in between
    the spectrum of structured and unstructured data.
    Another example is the metadata related to videos
    and audios files, which themselves fall under unstructured data.
    The metadata such as creator, last accessed, permissions,
    and more are semi-structured data.

    A DBMS is a software that allows the user to create, maintain,
     and delete multiple individual databases.

    A database is an organized and structured collection of data,
     usually stored and retrieved electronically.
     A database usually lives in a database management system.
     The structure and organization helps achieve efficient
     data retrieval

    Relational databases consist of data stored as rows in tables.
    The columns of a table follow a defined schema that describes
    the type and size of the data that a table column can hold.
    Think of a schema as a blueprint of each record or row in the table


    Big Data is the exponential increase and availability of data
    in our world. More formally, Big Data is defined as data with
    greater variety arriving in increasing volumes and with
    ever higher velocity and requires a scalable architecture
    for efficient storage, manipulation, and analysis.
    These properties are also known as the three Vs.
    These data sets are so voluminous that traditional
    data processing software just can’t manage them.
    But these massive volumes of data can be used
    to address business problems that couldn't be tackled before.
    - Volume: The sheer amount of data matters.
        It’s estimated that 40 zettabytes of data will
        be created by 2020, an increase of 300 times from 2005.
        With Big Data, one has to process high volumes of data.
        These can be data of unknown value, such as
        Twitter data feeds, click streams on a webpage or
        a mobile app, or sensor-enabled equipment.
        For some organizations, this might be tens
        of terabytes of data. For others,
        it may be hundreds of petabytes.
    - Velocity: Velocity is the rate at which data is received
        and acted on. Normally, the highest velocity of data
        streams directly into memory, instead of being written
        to disk. Some internet-enabled smart products operate
        in real-time or near real-time and will require
        real-time evaluation and action.
    - Variety: Variety refers to the many types of available data.
        Data comes in different forms. Structured data can be
        organized neatly within the columns of a database.
        This type of data is relatively easy to enter, store,
        query, and analyze. Unstructured data is more difficult
        to sort and extract value from. Examples of unstructured
        data include emails, social media posts, word-processing
        documents; audio, video, or photo files, web pages, and more.

    Recently, more Vs were added to the list of characteristics describing Big Data:

    - Veracity: This refers to the quality of the collected data.
        If source data is not correct, analyses will be worthless.
    - Value: Value is the tangible benefits that an organization
        can derive from data. Data has intrinsic value.
        But it’s of no use until value is discovered.
    - Visualization: Data must be understandable to
        nontechnical stakeholders and decision makers.
         Visualization is the creation of complex graphs that
         tell the data scientist’s story, transforming the
         data into information, information into insight,
         insight into knowledge, and knowledge into advantage.
    - Variability: The meaning and context of data may change
        over time. For example, language processing by
        computers is exceedingly difficult because words
        often have several meanings. Data scientists must
        account for this variability by creating sophisticated
        programs that understand context and meaning.



     */


}
