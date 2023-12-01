package com.bichel.algorithms.problemsheap.arrays;

/*
Given an array of non-negative integers nums,
you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
You can assume that you can always reach the last index.
 */

public class JumpGameII {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentJumpEnd = 0;
        int longestJump = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            longestJump = Math.max(longestJump, i + nums[i]);
            if (i == currentJumpEnd) {
                jumps++;
                currentJumpEnd = longestJump;
            }
        }

        return jumps;
    }
}
