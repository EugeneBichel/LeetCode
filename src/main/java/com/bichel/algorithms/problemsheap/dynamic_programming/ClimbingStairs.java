package com.bichel.algorithms.problemsheap.dynamic_programming;

public class ClimbingStairs {
    private int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climbStairs(0, n, memo);
    }

    private int usingDP(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] dp = new int[n + 1];

        dp[1] = 1; // if 1 stair then 1 combination
        dp[2] = 2; // if 2 stairs then 2 comb

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    private int climbStairs(int i, int n, int[] memo) {

        if (i > n) return 0;
        if (i == n) return 1;
        if (memo[i] > 0) return memo[i];

        memo[i] = climbStairs(i + 1, n, memo) + climbStairs(i + 2, n, memo);

        return memo[i];
    }
}
