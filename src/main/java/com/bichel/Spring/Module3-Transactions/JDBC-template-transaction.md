Is the JDBC template able to participate in an existing transaction?

Yes, JDBC Template is able to participate in existing transaction. It will support both, transaction created with @Transactional annotation and also programmatically created transaction.

JDBC Template is able to participate in existing transaction by usage of DataSourceUtils and TransactionSynchronizationManager. TransactionInterceptor and TransactionAspectSupport are also using PlatformTransactionManager together with DataSourceTransactionManager which will set transaction in TransactionSynchronizationManager for JDBC Template (or other components) to reuse.


