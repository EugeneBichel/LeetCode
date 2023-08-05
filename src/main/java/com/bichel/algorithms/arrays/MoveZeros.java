package com.bichel.algorithms.arrays;

public class MoveZeros {
    public void moveZeroes(int[] nums) {

        int numOfZeros = 0;

        for(int i=0; i< nums.length; i++) {
            if(nums[i] == 0) {
                numOfZeros++;
            } else {
                int temp = nums[i];
                nums[i] = 0;
                nums[i-numOfZeros] = temp;
            }
        }
    }
}
