package com.bichel.java;

import java.util.function.Predicate;

public class FunctionIntefacesTest {
    /*
    The Predicate<T> interface has an abstract method boolean test(T t).
    Basically, a predicate is a function that evaluates the given input and returns true or false.

    Supplier is an interface that does not take in any argument
    but produces a value when the get() function is invoked.
    Suppliers are useful when we don’t need to supply any value and
    obtain a result at the same time.

    Consumers are functional interfaces that take in a parameter and
    do not produce anything.

    Function is a category of functional interfaces that takes an object of type T
    and returns an object of type R.

    The UnaryOperator<T> interface represents a function that takes one argument
    of type T and returns a value of the same type. This is similar
    to the Function interface, which is a parent to the UnaryOperator interface.
     */
}

class PredicateDemo {

    static boolean isPersonEligibleForVoting(PredicatePerson person, Predicate<PredicatePerson> predicate){
        return predicate.test(person);
    }


    public static void main (String args[]){
        PredicatePerson person = new PredicatePerson("Alex", 23);
        // Created a predicate. It returns true if age is greater than 18.
        Predicate<PredicatePerson> predicate = p -> p.age > 18;

        boolean eligible = isPersonEligibleForVoting(person , predicate);

        System.out.println("Person is eligible for voting: " + eligible);
    }
}

class PredicatePerson {
    String name;
    int age;

    PredicatePerson(String name, int age){
        this.name = name;
        this.age = age;
    }
}
