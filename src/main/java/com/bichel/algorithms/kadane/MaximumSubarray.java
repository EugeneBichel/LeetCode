package com.bichel.algorithms.kadane;

/*
Given an integer array nums, find the
subarray
 with the largest sum, and return its sum.



Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int localMax = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int val = nums[i];

            localMax = Math.max(val, localMax + val);
            max = Math.max(max, localMax);
        }

        return max;
    }
}
