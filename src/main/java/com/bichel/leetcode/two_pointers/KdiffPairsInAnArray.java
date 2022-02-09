package com.bichel.leetcode.two_pointers;

import java.util.Arrays;

/*
Given an array of integers nums and an integer k,
return the number of unique k-diff pairs in the array.

A k-diff pair is an integer pair (nums[i], nums[j]),
where the following are true:

0 <= i < j < nums.length
|nums[i] - nums[j]| == k
Notice that |val| denotes the absolute value of val.
 */

public class KdiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {

        Arrays.sort(nums);

        int left = 0, right = 1;
        int result = 0;

        while (left < nums.length && right < nums.length) {
            if (left == right || nums[right] - nums[left] < k) {
                // List item 1 in the text
                right++;
            } else if (nums[right] - nums[left] > k) {
                // List item 2 in the text
                left++;
            } else {
                // List item 3 in the text
                left++;
                result++;
                while (left < nums.length && nums[left] == nums[left - 1])
                    left++;
            }
        }
        return result;
    }
}
