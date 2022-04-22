package com.bichel.other.basic;

public class Generic {
    public static void main(String[] args) {
        /*
        basic.Generic methods are those methods that are written
        with a single method declaration and can be called
        with arguments of different types.

        The compiler will ensure the correctness of whichever type is used. These are some properties of generic methods:

            basic.Generic methods have a type parameter (the diamond operator enclosing the type) before the return type of the method declaration
            Type parameters can be bounded (bounds are explained later in the article)
            basic.Generic methods can have different type parameters separated by commas in the method signature
            Method body for a generic method is just like a normal method
            An example of defining a generic method to convert an array to a list:

            public <T> List<T> fromArrayToList(T[] a) {
                return Arrays.stream(a).collect(Collectors.toList());

          Bounded Generics
            As mentioned before, type parameters can be bounded. Bounded means “restricted“, we can restrict types that can be accepted by a method.
            For example, we can specify that a method accepts a type and all its subclasses (upper bound) or a type all its superclasses (lower bound).

         public <T extends Number> List<T> fromArrayToList(T[] a) {
            ...
         }

         Multiple Bounds
            A type can also have multiple upper bounds as follows:

            <T extends Number & Comparable>
            If one of the types that are extended by T is a class (i.e Number), it must be put first in the list of bounds. Otherwise, it will cause a compile-time error.

          Type Erasure
Generics were added to Java to ensure type safety and to ensure that generics wouldn't cause overhead at runtime, the compiler applies a process called type erasure on generics at compile time.

Type erasure removes all type parameters and replaces it with their bounds or with Object if the type parameter is unbounded. Thus the bytecode after compilation contains only normal classes, interfaces and methods thus ensuring that no new types are produced. Proper casting is applied as well to the Object type at compile time.

This is an example of type erasure:

public <T> List<T> genericMethod(List<T> list) {
    return list.stream().collect(Collectors.toList());
}
With type erasure, the unbounded type T is replaced with Object as follows:

// for illustration
public List<Object> withErasure(List<Object> list) {
    return list.stream().collect(Collectors.toList());
}

// which in practice results in
public List withErasure(List list) {
    return list.stream().collect(Collectors.toList());
}
If the type is bounded, then the type will be replaced by the bound at compile time:

public <T extends Building> void genericMethod(T t) {
    ...
}
would change after compilation:

public void genericMethod(Building t) {
    ...
}




         */
    }
}
