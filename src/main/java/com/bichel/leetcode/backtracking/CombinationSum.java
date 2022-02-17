package com.bichel.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();

        this.backtrack(target, comb, 0, candidates, results);
        return results;
    }

    private void backtrack(int remain, LinkedList<Integer> comb, int start, int[] candidates, List<List<Integer>> results) {

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
