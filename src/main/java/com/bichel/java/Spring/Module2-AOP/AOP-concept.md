AOP – Aspect Oriented Programming – A programming paradigm that complements Object-oriented Programming (OOP) by providing a way to separate groups of crosscutting concerns from business logic code. 

This is achieved by ability to add additional behavior to the code without having to modify the code itself. This is achieved by specifying:
     Location of the code which behavior should be altered – Pointcut is matched
    with Join point
     Code which should be executed that implements cross cutting concern – Advice

Aspect Oriented Programming solves following challenges:
     Allows proper implementation of Cross-Cutting Concerns
     Solves Code Duplications by eliminating the need to repeat the code for
    functionalities across different layers, such functionalities may include logging,
    performance logging, monitoring, transactions, caching
     Avoids mixing unrelated code, for example mixing transaction logic code (commit, rollback) with business code makes code harder to read, by separating concerns code is easier to read, interpret, maintain

Common cross-cutting concerns:
     Logging
     Performance Logging
     Caching
     Security
     Transactions
     Monitoring

Implementing cross-cutting concerns without using AOP, produces following challenges:
     Code duplications – Before/After code duplicated in all locations when normally
    Advise would be applied, refactoring by extraction helps but does not fully solve
    the problem
     Mixing of concerns – business logic code mixed with logging, transactions,
    caching makes code hard read and maintain


