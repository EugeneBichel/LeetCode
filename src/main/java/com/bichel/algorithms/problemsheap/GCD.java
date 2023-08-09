package com.bichel.algorithms.problemsheap;

public class GCD {
    public static void main(String[] args) {
        System.out.println(getGCD(9,12));
    }

    private static int getGCD(int a, int b) {

        //a = bx + c
        //x is GCD when c = 0

        if(b == 0) {
            return a;
        }

        int c = a % b;

        return getGCD(b, c);
    }
}
