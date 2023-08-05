JPA can work with following transaction managers:
 JpaTransactionManager – recommended when working with one database and one Entity
Manager

 JtaTransactionManager – recommended when working with multiple databases and Entity
Managers, or when working with multiple databases and other transactional resources, for example
one transaction needs to span Database and JMS Topic

Usage of JpaTransactionManager in case of multiple Databases / Transactional Resources / Entity
Managers will cause each transaction, span only one resource, this is why JtaTransactionManager is
required in this case

Multiple Databases/Entity Managers Scenario with incorrectly used JpaTransactionManager
for this case use JtaTransactionManager
