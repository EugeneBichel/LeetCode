package com.bichel.algorithms.problemsheap;

/*
Given an integer array nums with possible duplicates,
randomly output the index of a given target number.
You can assume that the given target number must exist in the array.

Implement the Solution class:

Solution(int[] nums) Initializes the object with the array nums.
int pick(int target) Picks a random index i from nums where nums[i] == target.
If there are multiple valid i's, then each index should have an equal probability
of returning.
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class RandomPickIndex {
    private int[] nums;
    private Random rand;

    public RandomPickIndex(int[] nums) {
        // Do not allocate extra space for the nums array
        this.nums = nums;
        this.rand = new Random();
    }

    public int pick(int target) {
        List<Integer> indices = new ArrayList<>();
        int n = this.nums.length;

        for (int i = 0; i < n; ++i) {
            if (this.nums[i] == target) {
                indices.add(i);
            }
        }

        int l = indices.size();
        // pick an index at random
        int randomIndex = indices.get(rand.nextInt(l));
        return randomIndex;
    }
}
