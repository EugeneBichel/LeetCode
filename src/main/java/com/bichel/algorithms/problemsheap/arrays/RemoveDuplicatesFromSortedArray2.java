package com.bichel.algorithms.problemsheap.arrays;

class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 1;
        int duplicatesNum = 0;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                duplicatesNum++;
            }

            if(nums[i] != nums[i-1]) {
                nums[j++] = nums[i];
                duplicatesNum = 0;
            } else if((nums[i] == nums[i-1] && duplicatesNum < 2)) {
                nums[j++] = nums[i];
            }
        }

        return j;
    }
}