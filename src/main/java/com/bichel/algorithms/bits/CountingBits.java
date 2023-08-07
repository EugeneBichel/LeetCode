package com.bichel.algorithms.bits;

/*
Given an integer n, return an array ans of length n + 1
such that for each i (0 <= i <= n), ans[i] is the number
of 1's in the binary representation of i.

Example 1:
Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
 */

public class CountingBits {
    /*
    Approach 1: Pop Count
     */
    private int popCount(int x) {
        int count;
        for (count = 0; x != 0; count++) {
            x &= x - 1; // zeroing out the least significant nonzero bit
        }
        return count;
    }

    public int[] countBitsApproach1(int n) {
        int[] ans = new int[n + 1];
        for (int x = 0; x <= n; x++) {
            ans[x] = popCount(x);
        }
        return ans;
    }


}
