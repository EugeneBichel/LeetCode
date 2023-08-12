package com.bichel.algorithms.problemsheap.combinations_permutations;

/*
Given an integer array nums that may contain duplicates,
return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 2:
Input: nums = [0]
Output: [[],[0]]
 */

/*
Let us first review the problems of
Permutations / Combinations / Subsets,
since they are quite similar to each other
and there are some common strategies to solve them.

First, their solution space is often quite large:

Permutations: N!N!.

Combinations: C_N^k ={N!/(N - k)!*k!
Subsets: 2^N since each element could be absent or present.

Given their exponential solution space, it is tricky to ensure
that the generated solutions are complete and non-redundant.
It is essential to have a clear and easy-to-reason strategy.
There are generally three strategies to do it:

Recursion
Backtracking
Lexicographic generation based on the mapping between binary bitmasks
and the corresponding
permutations / combinations / subsets.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();

        if(nums == null || nums.length == 0) return subsets;

        //needs to use checking for duplicates using nums[i] == nums[i-1]
        Arrays.sort(nums);

        List<Integer> subset = new ArrayList<>();
        findAllSubsets(nums, subsets, subset, 0);

        return subsets;
    }

    private void findAllSubsets(int[] nums, List<List<Integer>> subsets, List<Integer> subset, int startInd) {
        subsets.add(new ArrayList<>(subset));

        for(int i = startInd; i < nums.length; i++) {
            if(i != startInd && nums[i] == nums[i-1]) {
                continue;
            }

            subset.add(nums[i]);
            findAllSubsets(nums, subsets, subset, i+1);
            //backtrack
            subset.remove(subset.size() - 1);
        }
    }
}
