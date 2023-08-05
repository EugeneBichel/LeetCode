package com.bichel.algorithms.backtracking;

/*
Given two integers n and k, return all possible combinations
of k numbers out of the range [1, n].
You may return the answer in any order.

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        LinkedList<Integer> combination = new LinkedList<>();

        backtrack(1, n, k, combination, combinations);
        return combinations;
    }

    private void backtrack(int first, int n, int k,
                           LinkedList<Integer> combination,
                           List<List<Integer>> combinations) {
        if (combination.size() == k) {
            combinations.add(new LinkedList<>(combination));
            return;
        }

        for (int i = first; i <= n; i++) {
            combination.add(i);
            backtrack(i + 1, n, k, combination, combinations);
            combination.removeLast();
        }
    }
}
