package com.bichel.algorithms.problemsheap.arrays;

import java.util.Arrays;

/*
Given an array of integers nums containing n + 1
integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums,
return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space.
 */

public class FindTheDuplicateNumber {
    public int findDuplicate2(int[] nums) {
        int n = nums.length - 1;
        int[] alphabet = new int[n];

        for(int i = 0; i < nums.length; i++) {
            int ind = nums[i];
            if(alphabet[ind-1] == 0)
                alphabet[ind-1] = ind;
            else return ind;
        }

        return -1;
    }
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
