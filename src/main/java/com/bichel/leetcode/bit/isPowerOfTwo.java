package com.bichel.leetcode.bit;

public class isPowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
        System.out.println(1 & 0);
        System.out.println(isPowerOfTwo(2));
        System.out.println((2 & 1));
        System.out.println(isPowerOfTwo(3));
        System.out.println((3 & 2));
        System.out.println(isPowerOfTwo(4));
        System.out.println((4 & 3));
        System.out.println(isPowerOfTwo(5));
        System.out.println((5 & 4));
        System.out.println(isPowerOfTwo(6));
        System.out.println((6 & 5));
        System.out.println(isPowerOfTwo(7));
        System.out.println((7 & 6));
        System.out.println(isPowerOfTwo(8));
        System.out.println((8 & 7));
        System.out.println(isPowerOfTwo(9));
        System.out.println((9 & 8));
        System.out.println(isPowerOfTwo(10));
        System.out.println((10 & 9));
    }

    private static boolean isPowerOfTwo(int x) {
        return x != 0 && (x & (x-1)) == 0;
    }
}
