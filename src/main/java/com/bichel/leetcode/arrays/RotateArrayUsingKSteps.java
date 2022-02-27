package com.bichel.leetcode.arrays;

/*
Given an array, rotate the array to the right by k steps,
where k is non-negative.

Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */

public class RotateArrayUsingKSteps {
    public void rotate(int[] nums, int k) {

        int N = nums.length;
        k = k % N;

        int[] kary = new int[k];

        for (int i = 0; i < k; i++) {
            kary[i] = nums[N - k + i];
        }

        for (int i = N - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = kary[i];
        }
    }
}
