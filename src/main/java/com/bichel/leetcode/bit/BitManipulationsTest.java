package com.bichel.leetcode.bit;

public class BitManipulationsTest {
    public static void main(String[] args) {
        int i = 4;

        int a = i >> 1;
        int b = i >>> 1;

        System.out.println(a); //2
        System.out.println(b); //2

        i = -4;

        a = i >> 1;
        b = i >>> 1;

        System.out.println(a); //-2
        System.out.println(b); //2147483646
    }
}
