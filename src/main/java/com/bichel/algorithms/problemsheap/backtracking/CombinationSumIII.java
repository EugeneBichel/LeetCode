package com.bichel.algorithms.problemsheap.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Leetcode 216:
Find all valid combinations of k numbers
that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations.
The list must not contain the same combination twice,
and the combinations may be returned in any order.

Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();

        this.backtrack(n, k, comb, 0, results);
        return results;
    }

    private void backtrack(int remain, int k,
                           LinkedList<Integer> comb, int next_start,
                           List<List<Integer>> results) {

        if (remain == 0 && comb.size() == k) {
            // Note: it's important to make a deep copy here,
            // Otherwise the combination would be reverted in other branch of backtracking.
            results.add(new ArrayList<Integer>(comb));
            return;
        } else if (remain < 0 || comb.size() == k) {
            // Exceed the scope, no need to explore further.
            return;
        }

        // Iterate through the reduced list of candidates.
        for (int i = next_start; i < 9; ++i) {
            comb.add(i + 1);
            this.backtrack(remain - i - 1, k, comb, i + 1, results);
            comb.removeLast();
        }
    }
}
