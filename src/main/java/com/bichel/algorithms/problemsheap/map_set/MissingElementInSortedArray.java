package com.bichel.algorithms.problemsheap.map_set;

/*
Given an integer array nums which is sorted in ascending order
and all of its elements are unique and given also an integer k,
return the kth missing number starting from the leftmost number of the array.

Example 1:
Input: nums = [4,7,9,10], k = 1
Output: 5
Explanation: The first missing number is 5.
 */

public class MissingElementInSortedArray {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        // If kth missing number is larger than
        // the last element of the array
        if (k > missing(n - 1, nums))
            return nums[n - 1] + k - missing(n - 1, nums);

        int left = 0, right = n - 1, pivot;
        // find left = right index such that
        // missing(left - 1) < k <= missing(left)
        while (left != right) {
            pivot = left + (right - left) / 2;

            if (missing(pivot, nums) < k) left = pivot + 1;
            else right = pivot;
        }
        // kth missing number is greater than nums[idx - 1]
        // and less than nums[idx]
        return nums[left - 1] + k - missing(left - 1, nums);
    }

    // returns how many numbers are missing until the element at index idx
    private int missing(int idx, int[] nums) {
        return nums[idx] - nums[0] - idx;
    }
}
