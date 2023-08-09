package com.bichel.algorithms.problemsheap.dp;

/*
You are given an integer array coins
representing coins of different denominations
and an integer amount representing
a total amount of money.
Return the fewest number of coins
that you need to make up that amount.
If that amount of money cannot be made up
by any combination of the coins, return -1.

You may assume that you have an infinite number
of each kind of coin.

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Input: coins = [2], amount = 3
Output: -1
 */

public class CoinChange {
    /*
    The problem could be solved with polynomial time
    using Dynamic programming technique.
    First, let's define:

    F(S)F(S) - minimum number of coins needed to make change
    for amount SS using coin denominations */


    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;

        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }
}
