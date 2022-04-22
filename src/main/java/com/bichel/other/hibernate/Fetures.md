2.2 JPQL
The Java Persistence Query Language is defined by the JPA standard and very similar to SQL. It operates on entities and their relationships instead of database tables. You can use it to create queries of low and moderate complexity.

TypedQuery<Author> q = em.createQuery(
  “SELECT a FROM Author a JOIN a.books b WHERE b.title = :title”,
Author.class);

Don’t use FetchType.EAGER
Eager fetching is another common reason for Hibernate performance issues. It tells Hibernate to initialize a relationship when it fetches an entity from the database.

1
2
@ManyToMany(mappedBy = “authors”, fetch = FetchType.EAGER)
private Set<Book> books = new HashSet<Book>();
How Hibernate fetches the related entities from the database depends on the relationship and the defined FetchMode. But that’s not the main issue. The main issue is, that Hibernate will fetch the related entities whether or not they are required for the given use case. That creates an overhead which slows down the application and often causes performance problems. You should use FetchType.LAZY instead and fetch the related entities only if you need them for your use case.

    @ManyToMany(mappedBy = “authors”, fetch = FetchType.LAZY)
    private Set<Book> books = new HashSet<Book>();


Use @Immutable when possible
Hibernate regularly performs dirty checks on all entities that are associated with the current PersistenceContext to detect required database updates. This is a great thing for all mutable entities. But not all entities have to be mutable. Entities can also map read-only database views or tables. Performing any dirty checks on these entities is an overhead that you should avoid. You can do this by annotating the entity with @Immutable. Hibernate will then ignore it in all dirty checks and will not write any changes to the database.

    @Entity
    @Immutable
    public class BookView {
     
      …
     
    }

Avoid cascade remove for huge relationships
Most developers (myself included) get a little nervous when they see a CascadeType.REMOVE definition for a relationship. It tells Hibernate to also delete the related entities when it deletes this one. There is always the fear that the related entity also uses cascade remove for some of its relationships and that Hibernate might delete more database records than intended. During all the years I’ve worked with Hibernate, this has never happened to me, and I don’t think it’s a real issue. But cascade remove makes it incredibly hard to understand what exactly happens if you delete an entity. And that’s something you should always avoid. If you have a closer look at how Hibernate deletes the related entities, you will find another reason to avoid it. Hibernate performs 2 SQL statements for each related entity: 1 SELECT statement to fetch the entity from the database and 1 DELETE statement to remove it. This might be OK, if there are only 1 or 2 related entities but creates performance issues if there are large numbers of them.
