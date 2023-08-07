package com.bichel.algorithms.bits.easy;

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        int digitsCount = 32;

        for(int i = 0; i < digitsCount; i++) {
            if((n & mask) != 0) {
                bits++;
            }

            mask <<= 1;
        }

        return bits;
    }
}
