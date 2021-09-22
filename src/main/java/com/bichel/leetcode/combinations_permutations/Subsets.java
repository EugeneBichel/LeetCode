package com.bichel.leetcode.combinations_permutations;

/*
Given an integer array nums of unique elements,
return all possible subsets (the power set).
The solution set must not contain duplicate subsets.
Return the solution in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

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
import java.util.List;

//backtracking
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        for (int size = 0; size <= nums.length; size++) {
            backtrack(0, size, new ArrayList<>(), nums, res);
        }

        return res;
    }

    private void backtrack(int first, int size, List<Integer> curr, int[] nums, List<List<Integer>> res) {
        if (curr.size() == size) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = first; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(i + 1, size, curr, nums, res);
            curr.remove(curr.size() - 1);
        }
    }
}
