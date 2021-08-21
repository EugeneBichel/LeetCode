package com.bichel.leetcode.dp;

/*
Given an integer n, return an array ans of length n + 1
such that for each i (0 <= i <= n),
ans[i] is the number of 1's in the binary representation of i.

Example 1:
Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10

Example 2:
Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101

It relates to the following ideas:
 - Pop Count,
 - Most Significant Bit,
 - Least Significant Bit,
 - Last Set Bit,
 - Dynamic Programming.
 */
public class CountBits {
    private static int[] countBits(int n) {
        return new int[n+1];
    }

    private static int[] usingDP(int num) {
        int[] ans = new int[num + 1];
        int i = 0, b = 1;
        // [0, b) is calculated
        while (b <= num) {
            // generate [b, 2b) or [b, num) from [0, b)
            while(i < b && i + b <= num){
                ans[i + b] = ans[i] + 1;
                ++i;
            }
            i = 0;   // reset i
            b <<= 1; // b = 2b
        }
        return ans;
    }

    private static int[] usingPopCount(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; ++i)
            ans[i] = popcount(i);
        return ans;
    }

    private static int popcount(int x) {
        int count;
        for (count = 0; x != 0; ++count)
            x &= x - 1; //zeroing out the least significant nonzero bit
        return count;
    }
}
