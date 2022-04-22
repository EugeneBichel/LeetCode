package com.bichel.other.basic;

import java.util.Comparator;

public class ComparableModel {
    public static void main(String[] args) {
        Comparator<Player> byId = Comparator.comparingInt(Player::getId);
    }

    /*

    Then, we must ask ourselves why use a Comparator if we already have Comparable?
    There are several reasons why:
    Sometimes, we can't modify the source code of the class whose objects we want to sort, thus making the use of Comparable impossible
    Using Comparators allows us to avoid adding additional code to our domain classes
    We can define multiple different comparison strategies which isn't possible when using Comparable

     */
}

class Person implements Comparable<Person> {

    private int id;

    @Override
    public int compareTo(Person o) {
        return Integer.compare(this.getId(), o.getId());
    }

    public int getId() {
        return id;
    }
}

class Player {
    private int id;

    public int getId() {
        return id;
    }
}
class PersonComparator implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}