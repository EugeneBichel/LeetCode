package com.bichel.algorithms.problemsheap.combinations_permutations_subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets3 {
    public List<List<Integer>> subsets(int[] nums) {
        final int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int size = 0; size < n + 1; size++) {
            backtrack(0, size, new ArrayList<>(), nums, res);
        }

        return res;
    }
    private void backtrack(int first, int subsetSize, ArrayList<Integer> subset, int[] nums, List<List<Integer>> res) {
        if (subset.size() == subsetSize) {
            res.add(new ArrayList<>( subset));
            return;
        }

        for (int i = first; i < nums.length; i++) {
            subset.add(nums[i]);

            backtrack(i + 1, subsetSize, subset, nums, res);

            // backtrack
            subset.remove(subset.size() - 1);
        }
    }
}
