package com.bichel.leetcode.search;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int pivot;

        while(l <= r) {
            pivot = l + (r-l) / 2;
            if(nums[pivot] == target) return pivot;
            else if(nums[pivot] < target) l = ++pivot;
            else r = --pivot;

        }

        return l;
    }
}
