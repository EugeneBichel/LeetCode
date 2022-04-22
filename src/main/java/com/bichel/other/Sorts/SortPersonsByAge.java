package com.bichel.other.Sorts; /**
 * Java inner class is defined inside the body of another class. Java inner class can be
 * declared private, public, protected, or with default access whereas
 * an outer class can have only public or default access.
 *
 * Java nested classes are divided into 2 types:
 *
 *  1. Static nested classes
 *      If the nested class is static, then it's called static nested class. Static nested classes can access
 *          only static members of the outer class. Static nested class is same as ony other top-level class and is
 *          nested for only packaging convenience.
 *
 *  2. Java inner classes
 *      Any non-static nested class is known as inner class in Java. Java inner class is associated with the
 *          object of the class and they can access all the varibales and methods of the outer class.
 *
 *      There are 2 special kinds of java inner classes:
 *          2.1 Local inner class
 *              If a class is defined in a method body, it is known as local inner class.
 *              Since local inner class is not associated with Object, we can not use private, public or protected
 *                  access modifiers with it. The only allowed modifiers are abstract or final.
 *              A local inner class can access all the members of the enclosing class and local final variables in the
 *                  scope it is defined.
 *          2.2 Anonymous inner class
 *              A local inner class without name is known as anonymous inner class.
 *              An anonymous class is defined and instantiated in a single statement.
 *  Since inner classes are associated with insance, we can't have any public static variables in them.
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
 *
 * The Java programming language allows you to define a class with another class.
 * Such a class is called a nested class
 *
 * class OuterClass {
 *     ...
 *     class NestedClass {
 *         ...
 *     }
 *     ...
 * }
 *
 * Nested classes are divided into 2 categories: static and non-static.
 * Nested classes that are declared static are called static nested classes.
 * Non-static nested classes are called inner classes.
 *
 * class OuterClass {
 *     ...
 *     static class NestedStaticClass {
 *         ...
 *     }
 *     ...
 *     class InnerClass {
 *         ...
 *     }
 *
 * }
 *
 * A nested class is a member of its enclosing class. Non-static nested classes (inner classes) have access to
 *  other members of the enclosing class, even if they are defined private.
 * Static nested classes do not have access to other members of the enclosing class.
 *
 * Why Use Nested Classes?
 Compelling reasons for using nested classes include the following:

 It is a way of logically grouping classes that are only used in one place: If a class is useful to only one other class,
    then it is logical to embed it in that class and keep the two together. Nesting such "helper classes" makes their package more streamlined.

 It increases encapsulation: Consider two top-level classes, A and B, where B needs access to members of A that would otherwise be declared private. By hiding class B within class A, A's members can be declared private and B can access them. In addition, B itself can be hidden from the outside world.

 It can lead to more readable and maintainable code: Nesting small classes within top-level classes places the code closer to where it is used.
 */


public class SortPersonsByAge {
    public static void main(String[] args) {

        /*
        // how to instantiate inner class
        SortPersonsByAge sortPersonsByAge = new SortPersonsByAge();
        InnerPerson innerPerson = sortPersonsByAge.new InnerPerson();
        */

        Person person1 = new Person("a", (byte)1);
        Person person2 = new Person("a", (byte)2);
        Person person3 = new Person("a", (byte)3);
        Person person4 = new Person("a", (byte)4);
        Person person5 = new Person("a", (byte)5);
        Person person6 = new Person("a", (byte)6);
        Person person7 = new Person("a", (byte)7);
        Person person8 = new Person("a", (byte)8);
        Person person9 = new Person("a", (byte)9);
        Person person10 = new Person("a", (byte)10);

        Person[] persons = {person3, person1, person7, person10, person2, person5, person8, person4, person6, person9};

        Arrays.sort(persons, Comparator.comparing(Person::getAge));

        //Collections.sort(persons, Comparator.comparing(Person::getAge));

        for(Person person: persons) {
            System.out.println(person);
        }

        System.out.println(Byte.MAX_VALUE);
    }

    private static Object[] timSort() {

        return new Object[3];
    }

    private static Object[] mergeSort() {

        return new Object[2];
    }

    //for our purposes we need nested static class
    private static class Person {
        private String fullName;
        //1 byte = 2^7 = 128 the 8's bit is a sign. Max age is 2^7 - 1 = 127 is more than enough
        private byte age;

        private Person(String fullName, byte age) {
            this.fullName = fullName;
            this.age = age;
        }

        public String getFullName() {
            return this.fullName;
        }

        private byte getAge() {
            return this.age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            if (age != person.age) return false;
            return fullName != null ? fullName.equals(person.fullName) : person.fullName == null;
        }

        @Override
        public int hashCode() {
            int result = fullName != null ? fullName.hashCode() : 0;
            result = 31 * result + (int) age;
            return result;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Person{");
            sb.append("fullName='").append(fullName).append('\'');
            sb.append(", age=").append(age);
            sb.append('}');
            return sb.toString();
        }
    }

    private class InnerPerson {

    }
}
