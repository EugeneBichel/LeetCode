package com.bichel.architecture;

public class NTier {
    /*
    An N-tier application is an application which has more than three components involved.

    What are those components?

    Cache
    Message queues for asynchronous behaviour
    Load balancers
    Search servers for searching through massive amounts of data
    Components involved in processing massive amounts of data
    Components running heterogeneous tech commonly known as web services etc.

    Why The Need For So Many Tiers? #
    Two software design principles that are key to explaining this are
        the Single Responsibility Principle
            &
        the Separation of Concerns.

    Single responsibility principle is a reason why
    I was never a fan of stored procedures.
    Stored procedures enable us to add business logic to the database,
    which is a big no for me. What if in future we want to plug in
    a different database? Where do we take the business logic?
    To the new database? Or do we try to refactor the application code &
    squeeze in the stored procedure logic somewhere?
    A database should not hold business logic, it should only take care
    of persisting the data. This is what the single responsibility principle
    is. And this is why we have separate tiers for separate components.



     */
}
