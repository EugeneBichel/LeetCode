Default methods are methods that can have a body. The most important use of default methods in interfaces is to provide additional functionality to a given type without breaking down the implementing classes.

Before Java 8, if a new method was introduced in an interface then all the implementing classes used to break. We would need to provide the implementation of that method in all the implementing classes.

However, sometimes methods have only single implementation and there is no need to provide their implementation in each class. In that case, we can declare that method as a default in the interface and provide its implementation in the interface itself.

The static methods in interfaces are similar to default methods but the only difference is that you can’t override them. Now, why do we need static methods in interfaces if we already have default methods?

Suppose you want to provide some implementation in your interface and you don’t want this implementation to be overridden in the implementing class, then you can declare the method as static.

In the above interface, we get a compilation error in the Car class because a static method cannot be overridden. Also, since a static method is hidden, we can’t call it from the object of the implementing class. The below code will also not compile.

What are functional interfaces? #
An interface that has a single abstract method is called a functional interface.

While an interface can have one or more default methods, it should have only one abstract method to be called a functional interface.

Java 8 has defined the java.util.function package, containing lots of functional interfaces. Some of the functional interfaces defined in Java 8 are Predicate, Consumer, Supplier, Function, etc.

The functional interface is used by lambda expressions.

What is @FunctionalInterface annotation? #
Any interface that has only one abstract method can be annotated with the @FunctionalInterface annotation.

This is not mandatory but if an interface is annotated with @FunctionalInterface annotation and someone tries to add another abstract method to the, the compiler will throw an error. Below is an example of a functional interface.

