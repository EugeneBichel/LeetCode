package com.bichel.algorithms.problemsheap.bits.medium;

public class BitwiseAndNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        // find the common 1-bits
        while (m < n) {
            m >>= 1;
            System.out.println("m = " + m);
            n >>= 1;
            System.out.println("n = " + n);
            shift++;
            System.out.println("shift = " + shift);
        }
        return m << shift;
    }

    public int rangeBitwiseAnd2(int m, int n) {
        while(n > m) {
            n = n & n-1;
        }

        return m & n;
    }
}
