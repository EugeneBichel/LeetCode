package com.bichel.algorithms.bit;

/*
The Hamming distance between two integers is the number
of positions at which the corresponding bits are different.

Given two integers x and y, return the Hamming distance between them.
 */

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int hammingDistance1(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            if (xor % 2 == 1)
                distance += 1;
            xor = xor >> 1;
        }
        return distance;
    }
}
