package com.bichel.algorithms.problemsheap.bits.medium;

/*
Given a non-empty array of integers nums, every element appears twice
except for one.
Find that single one.
You must implement a solution with a linear runtime complexity and
use only constant extra space.

Example 1:
Input: nums = [2,2,1]
Output: 1
 */

public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        int res = 0;

        for(int i = 0; i < nums.length; i++) {
            int freq = 0;
            for(int j = 0; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    freq++;
                }
                if(freq > 1) {
                    break;
                }
            }

            if(freq == 1) {
                return nums[i];
            }
        }

        return res;
    }
}
