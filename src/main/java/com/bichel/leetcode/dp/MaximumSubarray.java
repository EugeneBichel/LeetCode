package com.bichel.leetcode.dp;

/*
Given an integer array nums, find the contiguous subarray
(containing at least one number) which has the largest sum and return its sum.
A subarray is a contiguous part of an array.

Complexity Analysis
Time complexity: O(N), where N is the length of nums.
We iterate through every element of nums exactly once.

Space complexity: O(1)
No matter how long the input is,
we are only ever using 2 variables: currSubarray and maxSubarray
 */

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int currSubarray = nums[0];
        int maxSubarray = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            currSubarray = Math.max(num, currSubarray + num);
            maxSubarray = Math.max(maxSubarray, currSubarray);
        }

        return maxSubarray;
    }
}
