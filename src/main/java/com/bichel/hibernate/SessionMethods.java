package com.bichel.hibernate;

public class SessionMethods {
    /*
    The Session interface has several methods
    that eventually result in saving data to the database:
        persist,
        save,
        update,
        merge,
        saveOrUpdate.
     */

    /*
    Apart from object-relational mapping itself,
    one of the problems that Hibernate was intended
    to solve is the problem of managing entities during runtime.

    The notion of “persistence context” is Hibernate's solution
    to this problem. Persistence context can be thought of as
    a container or a first-level cache for all the objects
    that you loaded or saved to a database during a session.

    The session is a logical transaction, which boundaries are
    defined by your application’s business logic.
    When you work with the database through
    a persistence context, and all of your entity instances
    are attached to this context, you should always have
    a single instance of entity for every database record
    that you’ve interacted during the session with.
    In Hibernate, the persistence context is represented by
    org.hibernate.Session instance.

    Any entity instance in your application appears in one of the three main states in relation to the Session persistence context:
        transient — this instance is not, and never was, attached to a Session; this instance has no corresponding rows in the database; it's usually just a new object that you have created to save to the database;
        persistent — this instance is associated with a unique Session object; upon flushing the Session to the database, this entity is guaranteed to have a corresponding consistent record in the database;
        detached — this instance was once attached to a Session (in a persistent state), but now it’s not; an instance enters this state if you evict it from the context, clear or close the Session, or put the instance through serialization/deserialization process.

    When the entity instance is in the persistent state, all changes that you make to the mapped fields of this instance will be applied to the corresponding database records and fields upon flushing the Session. The persistent instance can be thought of as “online”, whereas the detached instance has gone “offline” and is not monitored for changes.
    This means that when you change fields of a persistent object, you don't have to call save, update or any of those methods to get these changes to the database: all you need is to commit the transaction, or flush or close the session, when you're done with it.

    It is important to understand from the beginning that all of the methods (persist, save, update, merge, saveOrUpdate) do not immediately result in the corresponding SQL UPDATE or INSERT statements. The actual saving of data to the database occurs on committing the transaction or flushing the Session.
    The mentioned methods basically manage the state of entity instances by transitioning them between different states along the lifecycle.

    The persist method is intended for adding a new entity instance to the persistence context, i.e. transitioning an instance from transient to persistent state.

    We usually call it when we want to add a record to the database (persist an entity instance):

        Person person = new Person();
        person.setName("John");
        session.persist(person);

    What happens after the persist method is called? The person object has transitioned from transient to persistent state. The object is in the persistence context now, but not yet saved to the database. The generation of INSERT statements will occur only upon commiting the transaction, flushing or closing the session.
    Notice that the persist method has void return type. It operates on the passed object “in place”, changing its state. The person variable references the actual persisted object.

    You may call this method on an already persistent instance, and nothing happens. But if you try to persist a detached instance, the implementation is bound to throw an exception. In the following example we persist the entity, evict it from the context so it becomes detached, and then try to persist again. The second call to session.persist() causes an exception, so the following code will not work:

        Person person = new Person();
        person.setName("John");
        session.persist(person);
        session.evict(person);
        session.persist(person); // PersistenceException!

    Save
    The save method is an “original” Hibernate method that does not conform to the JPA specification.

    Its purpose is basically the same as persist, but it has different implementation details. The documentation for this method strictly states that it persists the instance, “first assigning a generated identifier”. The method is guaranteed to return the Serializable value of this identifier.

        Person person = new Person();
        person.setName("John");
        Long id = (Long) session.save(person);
    The effect of saving an already persisted instance is the same as with persist. Difference comes when you try to save a detached instance:

        Person person = new Person();
        person.setName("John");
        Long id1 = (Long) session.save(person);

        session.evict(person);
        Long id2 = (Long) session.save(person);
    The id2 variable will differ from id1. The call of save on a detached instance creates a new persistent instance and assigns it a new identifier, which results in a duplicate record in a database upon committing or flushing.



     */


}
