package com.bichel.algorithms.unsorted;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given a set of candidate numbers (C) and a target number (T),
find all unique combinations in C where the candidate numbers sums to T.
The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order.
(ie, a1 ≤ a2 ≤ … ≤ ak).
The combinations themselves must be sorted in ascending order.
CombinationA > CombinationB if (a1 > b1) OR (a1 = b1 AND a2 > b2) OR …
(a1 = b1 AND a2 = b2 AND … ai = bi AND ai+1 > bi+1)
The solution set must not contain duplicate combinations.
 */

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();

        backtrack(target, comb, 0, candidates, results);

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
