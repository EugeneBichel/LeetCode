package com.bichel.algorithms.problemsheap.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given an array of distinct integers candidates and a target integer target,
return a list of all unique combinations of candidates where
the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times.
Two combinations are unique if the frequency of at least one
of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less
than 150 combinations for the given input.
 */

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();

        this.backtrack(target, comb, 0, candidates, results);
        return results;
    }

    private void backtrack(int remain, LinkedList<Integer> comb, int start,
                           int[] candidates, List<List<Integer>> results) {

        if (remain == 0) {
            results.add(new ArrayList<>(comb));
            return;
        } else if (remain < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            comb.add(candidates[i]);
            this.backtrack(remain - candidates[i], comb, i, candidates, results);
            comb.removeLast();
        }
    }
}
