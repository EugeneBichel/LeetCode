package com.bichel.algorithms.problemsheap.arrays;

/*
You are given an integer array nums. You are initially positioned at the array's first index,
and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.
 */

public class JumpGame {
    public boolean canJump(int[] nums) {
        boolean[] memo = new boolean[nums.length];
        memo[memo.length - 1] = true;

        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);

            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] == true) {
                    memo[i] = true;
                    break;
                }
            }
        }

        return memo[0];
    }

    public boolean canJump2(int[] nums) {
        int reachablePos = 0;

        for(int currPos = 0; currPos < nums.length; currPos++) {
            if(currPos > reachablePos) {
                return false;
            }

            reachablePos = Math.max(reachablePos, currPos + nums[currPos]);
        }

        return true;
    }
}
