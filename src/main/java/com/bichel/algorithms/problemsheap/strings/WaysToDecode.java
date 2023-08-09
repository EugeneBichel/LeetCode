package com.bichel.algorithms.problemsheap.strings;

/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
Given an encoded message A containing digits,
determine the total number of ways to decode it modulo 10^9 + 7.
 */

public class WaysToDecode {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i < dp.length; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }

            int twoDigit = Integer.valueOf(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }

            dp[i] %= 1000000007;
        }

        return dp[s.length()] % 1000000007;
    }
}
