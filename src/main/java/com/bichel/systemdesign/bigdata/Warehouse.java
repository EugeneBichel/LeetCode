package com.bichel.systemdesign.bigdata;

public class Warehouse {
    /*
    n contrast, organizations most often use databases for Online Transaction Processing (OLTP).
    Databases use OLTP to delete, insert, replace, and update large numbers of short, online transactions.
     In crux, databases are optimized for reading/writing, whereas a data warehouse is optimized
     for aggregation and retrieval of large data sets. Databases are often referred to as operational
     systems; they are used to process day-to-day transactions. A database is optimized to maximize
     the speed and efficiency with which data is updated (added, modified, or deleted) and enable
     faster analysis and data access. However, databases are generally not suitable for complex
     analytical queries because of the number of table joins required. This is where the data warehouse
     comes in. In a data warehouse, data is massaged into a format and possibly combined with other data
     sources allowing for faster processing of complex queries.

     Next, let's see the differences between Big Data and Data Warehousing.
     There is some debate around Big Data replacing Data Warehousing altogether.
     One of the shared goals is to support business intelligence. But one big difference is
     the source data. Data warehouses usually comprise granular and structured data which conforms
     to a schema, all held in a relational database. In case of Big Data, the source data follows
     a loose structure and is usually unrefined. Consider an airline ticketing website.
     When a customer purchases a ticket, the transaction is stored in a relational database
     on the backend. This transaction, and possibly data from other databases,
     is fed into the data warehouse for further analysis. But Big Data, in this context,
     would comprise of not only the purchase transaction but every twist and turn
     like the clicks the user made, the number of times the user visited the website
     before the final purchase was made, and more.

     For another example of difference, suppose we want to predict the results of an upcoming election.
     A Big Data solution could possibly scour social media, online newspapers, surveys,
     and television mentions to make a prediction within a degree of confidence.
     On the contrary, a Data Warehousing solution would record each voter's selection
     beforehand and announce a result that will match the actual outcome.

     Usually, data warehouses are compared to a Data Lake, rather than Big Data in general.
     Data lake, a Big Data concept, refers to storage of the raw, unstructured,
     and structured data from an organization's data sources but whose use has yet not been determined.
     A data lake hosts data of all types, sizes and formats in its native format until needed.
     A data lake is likely to be larger in storage capacity than a data warehouse.
     A data warehouse will carry processed data actively used for analysis.
     It may be smaller than a data lake because it will not hold data that may never be used.
      You may also hear about the term Data Mart, a subject-orientated subset of the data warehouse.
      It serves the needs of a particular department within an organization.
      It is specially designed for a particular line of business, such as sales, finance, or marketing.
      Finally, a data lake can be abused, in some instances, and degenerate
      into a data swamp when data flows into the data lake without any quality or governance checks.




     */
}
