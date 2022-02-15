package com.bichel.leetcode.backtracking;

import java.util.List;
import java.util.ArrayList;

/*
Given an integer array nums of unique elements,
return all possible subsets (the power set).

The solution set must not contain duplicate subsets.
Return the solution in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int size = 0; size < n + 1; size++) {
            backtrack(0, size, new ArrayList<>(), nums, res);
        }

        return res;
    }

    private void backtrack(int first, int size, ArrayList<Integer> curr, int[] nums, List<List<Integer>> res) {
        if (curr.size() == size) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = first; i < nums.length; i++) {
            curr.add(nums[i]);

            backtrack(i + 1, size, curr, nums, res);

            // backtrack
            curr.remove(curr.size() - 1);
        }
    }
}
