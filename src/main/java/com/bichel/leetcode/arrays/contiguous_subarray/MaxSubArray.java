package com.bichel.leetcode.arrays.contiguous_subarray;

public class MaxSubArray {

    public int usingKadaneAlgorithm(int[] nums) {
        int currentSubarray = nums[0];
        int maxSubarray = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            currentSubarray = Math.max(num, currentSubarray + num);
            maxSubarray = Math.max(maxSubarray, currentSubarray);
        }

        return maxSubarray;
    }

    public int maxSubArray(int[] nums) {
        int maxSubarray = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentSubarray = 0;
            for (int j = i; j < nums.length; j++) {
                currentSubarray += nums[j];
                maxSubarray = Math.max(maxSubarray, currentSubarray);
            }
        }

        return maxSubarray;
    }
}
