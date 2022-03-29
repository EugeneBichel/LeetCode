package com.bichel.leetcode.search;

/*
Given an array of distinct integers arr,
where arr is sorted in ascending order,
return the smallest index i that satisfies arr[i] == i.

If there is no such index, return -1.
 */

public class FixedPoint {
    public int fixedPoint(int[] arr) {

        int l = 0;
        int r = arr.length - 1;

        int ans = -1;

        while (l <= r) {

            int pivot = l + (r - l) / 2;

            if (arr[pivot] == pivot) {
                ans = pivot;
                r = pivot - 1;
            } else if (arr[pivot] < pivot) l = pivot + 1;
            else r = pivot - 1;
        }

        return ans;
    }
}
