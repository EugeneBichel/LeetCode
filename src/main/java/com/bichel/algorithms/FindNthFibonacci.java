package com.bichel.algorithms;

/*
Given an integer A you need to find the Ath fibonacci number modulo 109 + 7.

The first fibonacci number F1 = 1
The first fibonacci number F2 = 1

The nth fibonacci number Fn = Fn-1 + Fn-2 (n > 2)
 */

public class FindNthFibonacci {
    public int solve(int n) {
        if (n < 2) return n;

        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;

        int modulo = 1_000_000_007;

        for (int i = 2; i <= n; i++) {
            memo[i] = (memo[i - 1] + memo[i - 2]) % modulo;
        }

        return memo[n - 1];
    }
}
