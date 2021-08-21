package com.bichel.leetcode.math;

/*
Count the number of prime numbers
less than a non-negative number, n.

Example 1:
Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10,
they are 2, 3, 5, 7.
 */

public class CountPrimes {
    public int countPrimes(int n) {

        if (n <= 2) return 0;
        boolean[] nums = new boolean[n];

        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (nums[i] == false)
                for (int j = i * i; j < n; j += i) {
                    nums[j] = true;
                }
        }

        int numOfPrimes = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] == false) numOfPrimes++;
        }

        return numOfPrimes;
    }
}
