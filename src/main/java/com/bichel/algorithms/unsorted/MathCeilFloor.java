package com.bichel.algorithms.unsorted;

public class MathCeilFloor {
    public static void main(String[] args) {

        int n = 10;
        System.out.println(n >>> 1);
        System.out.println(Math.ceil(n >>> 1));
        System.out.println(Math.floor(n >>> 1));

        n = 9;
        System.out.println(n >>> 1);
        System.out.println(Math.ceil(n >>> 1));
        System.out.println(Math.floor(n >>> 1));
    }
}
