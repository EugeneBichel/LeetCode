package com.bichel.leetcode.combinations;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Permutations {
    private void backtrack(int n, List<Integer> nums,
                          List<List<Integer>> output, int first) {
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

    public List<List<Integer>> permute(int[] nums) {
        // init output list
        List<List<Integer>> output = new LinkedList<>();

        // convert nums into list since the output is a list of lists
        List<Integer> origin = new ArrayList<>();
        for (int num : nums)
            origin.add(num);

        int n = nums.length;
        backtrack(n, origin, output, 0);
        return output;
    }
}
