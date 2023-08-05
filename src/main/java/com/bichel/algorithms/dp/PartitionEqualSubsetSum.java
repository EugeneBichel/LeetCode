package com.bichel.algorithms.dp;
/*
Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Example 1:
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        if (totalSum % 2 == 1) return false;

        int subSetSum = totalSum / 2;
        int n = nums.length;

        Boolean[][] memo = new Boolean[n + 1][subSetSum + 1];

        return dfs(nums, n - 1, subSetSum, memo);
    }

    private boolean dfs(int[] nums, int n, int subSetSum, Boolean[][] memo) {
        if (subSetSum == 0) return true;
        if (n == 0 || subSetSum < 0) return false;

        if (memo[n][subSetSum] != null)
            return memo[n][subSetSum];

        boolean result = dfs(nums, n - 1, subSetSum - nums[n - 1], memo) ||
                dfs(nums, n - 1, subSetSum, memo);

        memo[n][subSetSum] = result;

        return result;
    }
}
