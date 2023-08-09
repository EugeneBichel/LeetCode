package com.bichel.algorithms.problemsheap.dp;

/*
Given a binary array nums, return the maximum number of consecutive 1's
in the array if you can flip at most one 0.

Example 1:
Input: nums = [1,0,1,1,0]
Output: 4
Explanation: Flip the first zero will get the maximum number of consecutive 1s.
After flipping, the maximum number of consecutive 1s is 4.

Time complexity : O(n)
    Since both the pointers only move forward,
    each of the left and right pointer traverse a maximum of n steps.
Space complexity : O(1)
     Same as the previous approach. We don't store anything other than variables.
     Thus, the space we use is constant because it is not correlated to the
     length of the input array.
 */

public class MaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] nums) {
        int longestSequence = 0;
        int left = 0;
        int right = 0;
        int numZeroes = 0;

        // while our window is in bounds
        while (right < nums.length) {

            // add the right most element into our window
            if (nums[right] == 0) {
                numZeroes++;
            }

            // if our window is invalid, contract our window
            while (numZeroes == 2) {
                if (nums[left] == 0) {
                    numZeroes--;
                }
                left++;
            }

            // update our longest sequence answer
            longestSequence = Math.max(longestSequence, right - left + 1);

            // expand our window
            right++;
        }
        return longestSequence;
    }
}
