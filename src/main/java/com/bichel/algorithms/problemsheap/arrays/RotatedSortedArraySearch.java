package com.bichel.algorithms.problemsheap.arrays;

import java.util.List;

/*
Given an array of integers A of size N and an integer B.

array A is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).

You are given a target value B to search. If found in the array, return its index, otherwise return -1.

You may assume no duplicate exists in the array.

NOTE:- Array A was sorted in non-decreasing order before rotation.

NOTE : Think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*
Input Format

The first argument given is the integer array A.
The second argument given is the integer B.
Output Format

Return index of B in array A, otherwise return -1

Time complexity : O(logN).
Space complexity : O(1).
 */

public class RotatedSortedArraySearch {
    private List<Integer> nums;
    private int target;

    public int search(final List<Integer> nums, int target) {
        this.nums = nums;
        this.target = target;

        int n = nums.size();

        if (n == 1)
            return this.nums.get(0) == target ? 0 : -1;

        int rotate_index = find_rotate_index(0, n - 1);

        // if target is the smallest element
        if (nums.get(rotate_index) == target)
            return rotate_index;
        // if array is not rotated, search in the entire array
        if (rotate_index == 0)
            return search(0, n - 1);
        if (target < nums.get(0))
            // search in the right side
            return search(rotate_index, n - 1);
        // search in the left side
        return search(0, rotate_index);
    }

    private int find_rotate_index(int left, int right) {
        if (nums.get(left) < nums.get(right))
            return 0;

        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums.get(pivot) > nums.get(pivot + 1))
                return pivot + 1;
            else {
                if (nums.get(pivot) < nums.get(left))
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return 0;
    }

    private int search(int left, int right) {
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums.get(pivot) == target)
                return pivot;
            else {
                if (target < nums.get(pivot))
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return -1;
    }
}
