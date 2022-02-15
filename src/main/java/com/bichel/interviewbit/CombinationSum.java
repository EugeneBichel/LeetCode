package com.bichel.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;

/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:

All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The combinations themselves must be sorted in ascending order.
CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR … (a1 = b1 AND a2 = b2 AND … ai = bi AND ai+1 > bi+1)
The solution set must not contain duplicate combinations.
 */

public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Set<ArrayList<Integer>> results = new HashSet<>();
        LinkedList<Integer> comb = new LinkedList<>();

        this.backtrack(B, comb, 0, A, results);

        ArrayList<ArrayList<Integer>> res = new ArrayList<>(results);
        Collections.sort(res, (l1, l2) -> {
            int i = 0, j = 0;
            while (Objects.equals(l1.get(i), l2.get(j))) {
                i++;
                j++;
            }
            return l1.get(i).compareTo(l2.get(j));
        });

        return res;
    }

    private void backtrack(int remain, LinkedList<Integer> comb, int start,
                           ArrayList<Integer> candidates, Set<ArrayList<Integer>> results) {

        if (remain == 0) {
            // make a deep copy of the current combination
            ArrayList<Integer> item = new ArrayList<>(comb);
            Collections.sort(item);
            results.add(item);
            return;
        } else if (remain < 0) {
            // exceed the scope, stop exploration.
            return;
        }

        for (int i = start; i < candidates.size(); i++) {
            // add the number into the combination
            comb.add(candidates.get(i));
            this.backtrack(remain - candidates.get(i), comb, i,
                    candidates, results);

            // backtrack, remove the number from the combination
            comb.removeLast();
        }
    }
}
