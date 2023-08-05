- Predicate: returns boolean, takes 1 param
- Supplier: returns generic type T, takes 0 param
- Consumer: returns void, takes generic type T param
- Function: returns generic type R, takes generic type t param
- UnaryOperator: returns T, takes T param
- BinaryOperator: returns T, takes 2 params of type T

A lambda expression is said to be capturing if it either accesses instance variables of it’s enclosing class or local variables (final or effectively final) from it’s enclosing scope.

A lambda expression can capture the three types of variables given below:

Static variables
Instance variables
Local variables
If a lambda expression captures a local variable then the variable should be either final or effectively final.

What is effectively final? #
Effectively final is a new concept that was introduced in Java 8. A non-final, local variable whose value is never changed after initialization is known as effectively final.

Before Java 8, we cannot use a non-final, local variable in an anonymous class. If you need to access a local variable in an anonymous class, then it should be declared as final. This restriction is relaxed in Java 8. Now, the compiler, itself can check if the value of a variable is not changed after the assignment. Then, it is effectively final.

Let’s look at an example of a capturing lambda. In the below example, our lambda is capturing a local variable called i. The value of this variable is initialized once and never changed, so it is effectively final.

 
