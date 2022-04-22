Repository interface is a Java interface that describes Dao with expected behaviors, based on which
Spring Data will automatically generate Dao logic. Repository interface takes Domain Class and ID of
type to manage.

Custom Repository interface needs to extend one of following interface:
     Repository – basic marker repository
     CrudRepository – adds generic methods for CRUD operations
     PagingAndSortingRepository – adds findAll methods for paging/sorting
     JpaRepository – JPA specific extension of Repository


To define Repository interface, you need to follow those steps:
     Create Java Interface that extends one of: Repository, CrudRepository,
    PagingAndSortingRepository, JpaRepository
     Create class with @Entity annotation
     Inside @Entity class, create a simple primary key annotated with @Id annotation or create class
    that will represent complex key annotated with @EmbeddedId annotation at field level and
    @Embeddable at key class definition level
     Use @EnableJpaRepositories to point out package to scan for Repositories 


Repository interface is an interface, not a class for Spring Data to be able to use JDK Dynamic Proxy to intercept all calls to repository and also to allow creation of custom base repositories for every Dao based on SimpleJpaRepository configured at @EnableJpaRepositories level.