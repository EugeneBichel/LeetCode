package com.bichel.other.basic;

public interface Vehicle {

    //void cleanVehicle();

    default void startVehicle() {
        System.out.println("Vehicle is starting");
    }

    /*
    The static methods in interfaces are similar to default methods but the only difference is that you can’t override them. Now, why do we need static methods in interfaces if we already have default methods?
    Suppose you want to provide some implementation in your interface and you don’t want this implementation to be overridden in the implementing class, then you can declare the method as static.
     */
    static void cleanVehicle(){
        System.out.println("I am cleaning vehicle");
    }
}

@FunctionalInterface
/*
An interface that has a single abstract method is called a functional interface.
 */
interface Functional {
    void doSomething(); //abstract method

    /*
    If we try to add one more abstract method in the above interface, the compiler shows an error. If an interface is annotated with @FunctionalInterface annotation but does not contain even a single abstract method, then the compiler also complains.
     */
    //void doMore();

    default void foo() {
        System.out.println("foo");
    }
}

class Car implements Vehicle {
    //@Override
    //public void cleanVehicle() {
    //    System.out.println("Cleaning the vehicle");
    //}

    public static void main(String args[]){
        Car car = new Car();
        //car.cleanVehicle();
        car.startVehicle();
    }
}

interface InterfaceB {

    default void printSomething() {
        System.out.println("I am inside B interface");
    }
}

interface InterfaceA {

    default void printSomething() {
        System.out.println("I am inside A interface");
    }
}

/*
The above class will not compile because of the Diamond problem in Java. To resolve the compilation issue, we will have to implement the printSomething() method as shown below:

 */
class FooWith2InterfacesTheSameDefM implements InterfaceA, InterfaceB {

    @Override
    public void printSomething() {

        //Option 1 -> Provide our own implementation.
        System.out.println("I am inside Main class");

        //Option 2 -> Use existing implementation from interfaceA or interfaceB or both.
        InterfaceA.super.printSomething();
        InterfaceB.super.printSomething();


    }
}
