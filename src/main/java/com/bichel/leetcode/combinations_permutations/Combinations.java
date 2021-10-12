package com.bichel.leetcode.combinations_permutations;

/*
Given two integers n and k, return all possible combinations
of k numbers out of the range [1, n].

You may return the answer in any order.
 */

/*
Backtracking is an algorithm for finding all solutions
by exploring all potential candidates.
If the solution candidate turns to be not a solution (or at least not the last one),
 backtracking algorithm discards it by making some changes on the previous step,
  i.e. backtracks and then try again.

Here is a backtrack function which takes a first integer
to add and a current combination as arguments backtrack(first, curr).

If the current combination is done - add it to output.
Iterate over the integers from first to n.
Add integer i into the current combination curr.
Proceed to add more integers into the combination : backtrack(i + 1, curr).
Backtrack by removing i from curr.
 */

import java.util.LinkedList;
import java.util.List;

public class Combinations {
    List<List<Integer>> output = new LinkedList();
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;

        backtrack(1, new LinkedList<Integer>());

        return output;
    }

    private void backtrack(int first, LinkedList<Integer> curr) {
        // if the combination is done
        if (curr.size() == k)
            output.add(new LinkedList(curr));

        for (int i = first; i < n + 1; ++i) {
            // add i into the current combination
            curr.add(i);
            // use next integers to complete the combination
            backtrack(i + 1, curr);
            // backtrack
            curr.removeLast();
        }
    }
}
