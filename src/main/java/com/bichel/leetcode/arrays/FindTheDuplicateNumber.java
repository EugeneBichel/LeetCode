package com.bichel.leetcode.arrays;

import java.util.Arrays;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int[] n = new int[nums.length];
        Arrays.fill(n, 0);

        for(int i=0; i<nums.length; i++) {
            if(n[nums[i]] == 1 ) return nums[i];
            n[nums[i]] = 1;
        }

        return -1;
    }

    public int usingCircle(int[] nums) {

        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];

        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        tortoise = nums[0];

        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }
}
