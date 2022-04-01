package com.bichel.leetcode.dp;

/*
Given an array nums which consists of non-negative integers and an integer m,
you can split the array into m non-empty continuous subarrays.

Write an algorithm to minimize the largest sum among these m subarrays.

Here N is the length of the array and M is the number of subarrays allowed.
Time complexity: O(N^2 * M)
Space complexity: O(N⋅M)
 */

public class SplitArrayLargestSum {
    // Defined it as per the maximum size of array and split count
    // But can be defined with the input size as well
    Integer[][] memo = new Integer[1001][51];

    private int getMinimumLargestSplitSum(int[] prefixSum, int currIndex, int subarrayCount) {
        int n = prefixSum.length - 1;

        // We have already calculated the answer so no need to go into recursion
        if (memo[currIndex][subarrayCount] != null) {
            return memo[currIndex][subarrayCount];
        }

        // Base Case: If there is only one subarray left, then all of the remaining numbers
        // must go in the current subarray. So return the sum of the remaining numbers.
        if (subarrayCount == 1) {
            return memo[currIndex][subarrayCount] = prefixSum[n] - prefixSum[currIndex];
        }

        // Otherwise, use the recurrence relation to determine the minimum largest subarray
        // sum between currIndex and the end of the array with subarrayCount subarrays remaining.
        int minimumLargestSplitSum = Integer.MAX_VALUE;
        for (int i = currIndex; i <= n - subarrayCount; i++) {
            // Store the sum of the first subarray.
            int firstSplitSum = prefixSum[i + 1] - prefixSum[currIndex];

            // Find the maximum subarray sum for the current first split.
            int largestSplitSum = Math.max(firstSplitSum,
                    getMinimumLargestSplitSum(prefixSum, i + 1, subarrayCount - 1));

            // Find the minimum among all possible combinations.
            minimumLargestSplitSum = Math.min(minimumLargestSplitSum, largestSplitSum);

            if (firstSplitSum >= minimumLargestSplitSum) {
                break;
            }
        }

        return memo[currIndex][subarrayCount] = minimumLargestSplitSum;
    }

    public int splitArray(int[] nums, int m) {
        // Store the prefix sum of nums array.
        int n = nums.length;
        int[] prefixSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        return getMinimumLargestSplitSum(prefixSum, 0, m);
    }
}
