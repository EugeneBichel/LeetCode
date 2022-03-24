package com.bichel.leetcode.backtracking;

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
    private List<List<Integer>> output = new LinkedList<>();
    private int n;
    private int k;

    private void backtrack(int first, LinkedList<Integer> curr) {
        // if the combination is done
        if (curr.size() == k)
            output.add(new LinkedList<>(curr));

        for (int i = first; i < n + 1; i++) {
            // add i into the current combination
            curr.add(i);
            // use next integers to complete the combination
            backtrack(i + 1, curr);
            // backtrack
            curr.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<>());
        return output;
    }

    //other solution
    public static List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> combs = new ArrayList<>();
        combine(combs, new ArrayList<>(), 1, n, k);
        return combs;
    }

    private static void combine(List<List<Integer>> combs, List<Integer> comb,
                                int start, int n, int k) {
        if (k == 0) {
            combs.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i <= n; i++) {
            comb.add(i);
            combine(combs, comb, i + 1, n, k - 1);
            comb.remove(comb.size() - 1);
        }
    }
}
