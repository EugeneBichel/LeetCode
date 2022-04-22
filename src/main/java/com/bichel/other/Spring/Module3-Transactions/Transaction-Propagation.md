Transaction propagation defines how existing transaction is re-used when calling @Transactional method with transaction already running.

Transaction propagation can be defined in @Transactional annotation in propagation field as one of following options:
- REQUIRED - support a current transaction, create a new one of none exists
- SUPPORTS - support a current transcation, execute non-transactionally if none exists
- MANDATORY - support a current transaction, throw an exception if none exists
- REQUIRES_NEW - create a new transaction, and suspend the current transaction of one exists
- NOT_SUPPORTED - execute non-transactionally, suspend the current transaction if one exists
- NEVER - execute non-transactionally, throw an exception of a transaction exists
- NESTED - execute within a nested transaction if a current transaction exists, behave like REQUIRED else


