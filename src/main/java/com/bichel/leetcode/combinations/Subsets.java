package com.bichel.leetcode.combinations;

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

/*
very small solution is

for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
  // generate bitmask, from 0..00 to 1..11
  String bitmask = Integer.toBinaryString(i).substring(1);
}

public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> output = new ArrayList();
    int n = nums.length;

    for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
      // generate bitmask, from 0..00 to 1..11
      String bitmask = Integer.toBinaryString(i).substring(1);

      // append subset corresponding to that bitmask
      List<Integer> curr = new ArrayList();
      for (int j = 0; j < n; ++j) {
        if (bitmask.charAt(j) == '1') curr.add(nums[j]);
      }
      output.add(curr);
    }
    return output;
  }


 */

//backtracking
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        findAllSubsets(nums, ans, subset, 0);

        return ans;
    }

    private void findAllSubsets(int[] nums, List<List<Integer>> ans, List<Integer> subset, int startInd) {
        ans.add(new ArrayList<>(subset));

        for(int i = startInd; i < nums.length; i++) {

            subset.add(nums[i]);
            findAllSubsets(nums, ans, subset, i+1);
            subset.remove(subset.size() - 1);
        }
    }
}
