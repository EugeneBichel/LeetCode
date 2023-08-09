package com.bichel.algorithms.problemsheap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
Given an array A of size N denoting collection of numbers that might contain duplicates,
return all possible unique permutations.
NOTE: No 2 entries in the permutation sequence should be the same.
 */

public class AllUniquePermutations {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        Set<ArrayList<Integer>> output = new HashSet<>();

        int n = nums.size();
        backtrack(n, nums, output, 0);
        return new ArrayList<>(output);
    }

    private void backtrack(int n,
                           ArrayList<Integer> nums,
                           Set<ArrayList<Integer>> output,
                           int first) {
        // if all integers are used up
        if (first == n)
            output.add(new ArrayList<>(nums));

        for (int i = first; i < n; i++) {
            // place i-th integer first
            // in the current permutation
            Collections.swap(nums, first, i);
            // use next integers to complete the permutations
            backtrack(n, nums, output, first + 1);
            // backtrack
            Collections.swap(nums, first, i);
        }
    }
}
