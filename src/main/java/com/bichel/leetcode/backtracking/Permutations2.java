package com.bichel.leetcode.backtracking;

/*
Given a collection of numbers, nums, that might contain duplicates,
return all possible unique permutations in any order.

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> output = new HashSet<>();

        ArrayList<Integer> numsList = new ArrayList<>();
        for (int num : nums)
            numsList.add(num);

        int n = nums.length;
        backtrack(n, numsList, output, 0);
        return new ArrayList<>(output);
    }

    private void backtrack(int n, ArrayList<Integer> nums,
                           Set<List<Integer>> output, int first) {
        // if all integers are used up
        if (first == n)
            output.add(new ArrayList<>(nums));

        for (int i = first; i < n; i++) {
            Collections.swap(nums, first, i);

            backtrack(n, nums, output, first + 1);

            Collections.swap(nums, first, i);
        }
    }
}
