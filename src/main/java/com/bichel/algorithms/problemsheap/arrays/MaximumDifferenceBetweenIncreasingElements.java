package com.bichel.algorithms.problemsheap.arrays;

public class MaximumDifferenceBetweenIncreasingElements {
    public int maximumDifference(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int ans = -1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] <= min) {
                min = nums[i];
                max = Integer.MIN_VALUE;
            }
            else if (nums[i] >= max) {
                max = nums[i];
                ans = Math.max(ans, max - min);
            }
        }

        return ans;
    }
}
