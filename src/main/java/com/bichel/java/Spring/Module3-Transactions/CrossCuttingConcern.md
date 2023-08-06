Transaction is a cross cutting concern and in Spring it is implemented with usage of @Transactional annotation.

If @Transactional annotation is present on top of the method or entire class, then each call to the method in the class will be proxied by TransactionInterceptor and TransactionAspectSupport classes. 

Those classes will interact with PlatformTransactionManager to commit transaction upon successful method execution or rollback upon exception. 

Exact behavior will be dependent on transaction propagation and isolation level settings, which can be set in @Transactional annotation.


