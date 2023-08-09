package com.bichel.algorithms.problemsheap.arrays;

/*
Given an array nums, partition it into two (contiguous)
subarrays left and right so that:

Every element in left is less than or equal to every element in right.
left and right are non-empty.
left has the smallest possible size.
Return the length of left after such a partitioning.
It is guaranteed that such a partitioning exists.

Example 1:
Input: nums = [5,0,3,8,6]
Output: 3
Explanation: left = [5,0,3], right = [8,6]

Example 2:
Input: nums = [1,1,1,0,6,12]
Output: 4
Explanation: left = [1,1,1,0], right = [6,12]
 */

public class DisjointIntervals {
    public int partitionDisjoint(int[] nums) {

        int len = 0;
        int[] temp = new int[nums.length];
        temp[nums.length - 1] = nums[nums.length - 1];

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
        }

        for (int i = nums.length - 2; i >= 1; i--) {
            int min = Math.min(temp[i + 1], nums[i]);
            temp[i] = min;
        }

        max = 0;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (max <= temp[i + 1])
                return i + 1;
        }

        return len;
    }
}
