package com.bichel.algorithms.search;

/*
Suppose an array of length n sorted in ascending order
is rotated between 1 and n times. For example,
the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]]
1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements,
return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.
 */

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int N = nums.length;
        int l = 0;
        int r = N - 1;

        if (N == 1)
            return nums[0];
        if (nums[l] <= nums[r])
            return nums[l];

        while (l <= r) {

            int pivot = l + (r - l) / 2;

            if (nums[pivot] > nums[pivot + 1])
                return nums[pivot + 1];
            else if (nums[pivot - 1] > nums[pivot])
                return nums[pivot];

            if (nums[pivot] > nums[0]) {
                l = pivot + 1;
            } else {
                r = pivot - 1;
            }
        }

        return -1;
    }
}
