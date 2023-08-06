Transaction is an operation that consist of series of tasks, in which all of those tasks
should be performed, or none of the tasks should be performed. Those tasks are being
treated as one unit of work. If all tasks in transaction are successful, changes made by
those tasks are preserved, if at least one of the tasks is unsuccessful, changes made
by tasks that were already completed will be reverted and any tasks awaiting
execution will no be executed.


Transaction should follow ACID principle:
 Atomicity – All changes are applied or none changes are applied
 Consistency – system should go from one valid state to other valid state, any
constraints on data should never be left in invalid state
 Isolation – one transaction cannot affect other one, concurrent execution of
transaction should leave system in the same state as if sequential execution of
transaction would be performed
 Durability – guarantees that if transaction has been committed, data will be
preserved, even in case of system/power failure

Global transaction is a kind of transaction that spans multiple transactional
resources. Those resources can be anything, but usually include databases (can
be more then one) and queues. In Java, popular standard for managing global
transaction is JTA, which is an API for using transaction system provided by
Application Server.

Local transaction are resource specific transaction, they do not span across
multiple transactional resources. Local transactions are much simpler than global
transaction however main disadvantages is lack of ability to treat series of tasks
dealing with multiple transactional resources such as databases or databases and
queues as single unit of work.


