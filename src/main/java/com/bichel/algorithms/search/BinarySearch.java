package com.bichel.algorithms.search;

/*
Given an array of integers nums which is sorted in ascending order,
and an integer target, write a function to search target in nums.
If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity
 */

public class BinarySearch {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int pivot = l + (r - l) / 2;

            if (nums[pivot] == target) return pivot;
            else if (nums[pivot] < target) l = pivot + 1;
            else r = pivot - 1;
        }

        return -1;
    }
}
