Dependency Injection is a technique of creating software in which objects do not create their
dependencies on itself, instead objects declare dependencies that they need and it is external
object job or framework job to provide concrete dependencies to objects.

Types of Dependency Injection:
 Constructor injection
 Setter injection
 Interface injection

Advantages of using dependency injection is:
 Increases code reusability
 Increases code readability
 Increases code maintainability
 Increases code testability
 Reduces coupling
 Increases cohesion

A Software Design Pattern is a reusable solution to often, commonly occurring problem in
software design. It is a high level description on how to solve the problem, that can be used in
many different situations. Design patterns often represent best practices that developers can use
to solve common problems.

Dependency Injection is a pattern that solves problem of flexible dependencies creation.

Anti-pattern is ineffective and counter-productive solution to often occurring problem.
Examples of Anti-patterns in Object Oriented Programming:
 God Object
 Sequential coupling
 Circular dependency
 Constant interface


What is an interface?
OOP Definition – An interface is a description of actions that object can do, it is a way to enforce actions on object that implements the interface

Java Definition – An interface is a reference type, which contains collections of abstract
method. Class that implements the interface, must implement all methods from this
interface, or it needs to declare methods as abstract if object does not know how to
implement specified method. Java Interface may contain also:
 Constants
 Default Methods (Java 8)
 Static methods
 Nested types

Advantages of using interfaces in Java:
 Allows decoupling between contract and its implementation
 Allows declaring contract between callee and caller
 Increases interchangeability
 Increases testability

Advantages of using interfaces in Spring:
 Allows for use of JDK Dynamic Proxy
 Allows implementation hiding
 Allows to easily switch beans


