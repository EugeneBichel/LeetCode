package com.bichel.algorithms.problemsheap;

import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    public int lis(final List<Integer> nums) {
        int[] dp = new int[nums.size()];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (nums.get(j) < nums.get(i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int longest = 0;
        for (int l : dp) {
            longest = Math.max(longest, l);
        }

        return longest;
    }
}
