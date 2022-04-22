package com.bichel.other.basic;

import javax.xml.crypto.dsig.SignatureMethod;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
}

class ComparatorDemo {

    public static void main(String args[]){
        List<SimplePerson> personList = new ArrayList<>();
        personList.add(new SimplePerson("Jane", 54));
        personList.add(new SimplePerson("Dave", 21));
        personList.add(new SimplePerson("Carl", 34));
        // Sorting the List using comparing() method of Comparator.
        Collections.sort(personList, Comparator.comparing(SimplePerson::getName));
        //the same as Collections.sort
        //personList.sort(Comparator.comparing(SimplePerson::getName));

        personList.forEach(System.out::println);

        //Using thenComparing() method to sort the List on the basis of two criteria
        Collections.sort(personList, Comparator
                .comparing(SimplePerson::getName)
                .thenComparing(SimplePerson::getAge));

        personList.forEach(System.out::println);
    }
}

class SimplePerson {
    String name;
    int age;
    int yearsOfService;

    SimplePerson(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}