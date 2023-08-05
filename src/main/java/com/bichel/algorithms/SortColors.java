package com.bichel.algorithms;

/*
Given an array nums with n objects colored red, white, or blue,
sort them in-place so that objects of the same color are adjacent,
with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue,
respectively.
You must solve this problem without using the library's sort function.

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
 */

public class SortColors {
    public void sortColors(int[] nums) {
        int[] arr = new int[3];
        for (int val : nums) {
            arr[val]++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (arr[0] > 0) {
                nums[i] = 0;
                arr[0]--;
            } else if (arr[1] > 0) {
                nums[i] = 1;
                arr[1]--;
            } else {
                nums[i] = 2;
                arr[2]--;
            }
        }
    }
}
