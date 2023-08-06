Transaction Isolation determines how changes made under one transaction are visible in other transactions and to other users of the system. Higher isolation level means that changes from one transaction are not visible and lower isolation level means that changes from on transactions may “slip” into selects executed under other transaction.

Higher transaction isolation level make data being visible in more consistent way, lower transaction isolation level makes data less consistent but increases overall throughput and concurrency of the system.

There are three challenges that may occur due to Transaction Isolation Level:
     Phantom Read
     Non-repeatable Read
     Dirty read

### Phantom Read
Phantom read:
     Transaction A - first read
         select id, first_name, last_name from employees where id between 5 and 10
     Transaction B - write
         insert into employees values(7, ‘John’, ‘Doe’);
     Transaction A - second read
         select id, first_name, last_name from employees where id between 5 and 10

High Isolation Level will make second read returning same values as first read, lower isolation level will include new row with id 7 in second read.

To prevent phantom read, you need to pick isolation level that uses range locks.

### Non-repeatable Read
Non-repeatable read:
     Transaction A - first read
         select id, first_name, last_name from employees where id = 5
     Transaction B – write & commit
         update employees set last_name = ‘Doe’ where id = 5
     Transaction A - second read
         select id, first_name, last_name from employees where id = 5

High Isolation Level will make second read returning same values as first read, lower isolation level will read new values for record 5.

To prevent non-repeatable reads you need to use isolation level that uses readwrite locks on data being processed.

### Dirty Read
Dirty read:
     Transaction A - first read
         select id, first_name, last_name from employees where id = 5
     Transaction B – write (commit does not have to happen)
         update employees set last_name = ‘Doe’ where id = 5
     Transaction A - second read
         select id, first_name, last_name from employees where id = 5

High Isolation Level will make second read returning same values as first read, lower isolation level will read new values for record 5, even if Transaction B will not commit the data.

To prevent dirty reads you need to use isolation level that prevents uncommitted changes by other transaction being visible in your transaction.

Most Relational Databases support 4 transaction isolation levels:
     Serializable
         Highest Isolation Level
         Read-Write Locks held until end of transaction
         Range Locks held until end of transaction
     Repeatable Read
         Read-Write Locks held until end of transaction
     Read Committed
         Read Locks held until end of select statement
         Write Locks held until end of transaction
     Read Uncommitted
         Lowest isolation level
         It is possible to see changes from other transactions that are not committed

In Spring Framework, you can use @Transactional annotation to set isolation level.
    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)

Isolation Level | Phantom Read | Non-repeatable | Read Dirty    | Read Concurrency
------------------------------------------------------------------------------------
Serializable    | Not possible | Not possible   | Not possible  | Very poor
Repeatable Read | Possible     | Not possible   | Not possible  | Poor
Read Committed  | Possible     | Possible       | Not possible  | Good
Read Uncommitted| Possible     | Possible       | Possible Very | Good


