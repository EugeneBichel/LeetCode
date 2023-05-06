package com.bichel.leetcode.arrays;

import java.util.Arrays;

/*
Given an array nums of integers and integer k,
return the maximum sum such
that there exists i < j with nums[i] + nums[j] = sum and sum < k.
If no i, j exist satisfying this equation, return -1.

Example 1:
Input: nums = [34,23,1,24,75,33,54,8], k = 60
Output: 58
Explanation: We can use 34 and 24 to sum 58 which is less than 60.
 */

public class TwoSumLessThanK {
    public int twoSumLessThanK(int[] nums, int k) {
        int ans = -1;
        Arrays.sort(nums);

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int sum = nums[l] + nums[r];

            if (sum < k) {
                ans = Math.max(ans, sum);
                l++;
            } else r--;
        }

        return ans;
    }
}
