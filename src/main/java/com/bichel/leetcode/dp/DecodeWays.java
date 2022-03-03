package com.bichel.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/*
A message containing letters from A-Z can be encoded
into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must
be grouped then mapped back into letters using
the reverse of the mapping above (there may be multiple ways).

For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot
be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways
to decode it.

The answer is guaranteed to fit in a 32-bit integer.
 */

public class DecodeWays {

    //DP
    public int numDecodingsUsingDP(String s) {
        // DP array to store the subproblem results
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        // Ways to decode a string of size 1 is 1. Unless the string is '0'.
        // '0' doesn't have a single digit decode.
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for(int i = 2; i < dp.length; i++) {
            // Check if successful single digit decode is possible.
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }

            // Check if successful two digit decode is possible.
            int twoDigit = Integer.valueOf(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }


    Map<Integer, Integer> memo = new HashMap<>();

    public int numDecodings(String s) {
        return recursiveWithMemo(0, s);
    }

    private int recursiveWithMemo(int index, String s) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        if (index == s.length()) return 1;
        if (s.charAt(index) == '0') return 0;
        if (index == s.length() - 1) return 1;

        int ans = recursiveWithMemo(index + 1, s);

        if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            ans += recursiveWithMemo(index + 2, s);
        }

        memo.put(index, ans);

        return ans;
    }
}
