package com.bichel.leetcode.arrays;

/*
Given an integer array nums, move all the even integers
at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.
 */

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            if (nums[l] % 2 > nums[r] % 2) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }

            if (nums[l] % 2 == 0) l++;
            if (nums[r] % 2 == 1) r--;
        }

        return nums;
    }
}
