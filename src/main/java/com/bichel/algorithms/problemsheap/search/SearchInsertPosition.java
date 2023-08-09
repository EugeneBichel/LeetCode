package com.bichel.algorithms.problemsheap.search;

/*
Given a sorted array of distinct integers and a target value,
return the index if the target is found. If not,
return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 */

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int pivot = l + (r - l) / 2;

            if (nums[pivot] == target) return pivot;
            if (nums[pivot] < target) l = pivot + 1;
            else r = pivot - 1;
        }

        return l;
    }
}
