package com.bichel.leetcode.arrays;

/*
Given an array of positive integers nums
and a positive integer target,
return the minimal length of a contiguous subarray
[numsl, numsl+1, ..., numsr-1, numsr]
of which the sum is greater than or equal to target.
If there is no such subarray, return 0 instead.

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3]
has the minimal length under the problem constraint.
 */

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int left = 0;

        int prefixSum = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];

            while (prefixSum >= target) {
                ans = Math.min(ans, i + 1 - left);
                prefixSum -= nums[left++];
            }
        }

        return ans != Integer.MAX_VALUE ? ans : 0;
    }
}
