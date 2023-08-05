package com.bichel.algorithms.backtracking;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Design the CombinationIterator class:

CombinationIterator(string characters, int combinationLength) Initializes the object with a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
next() Returns the next combination of length combinationLength in lexicographical order.
hasNext() Returns true if and only if there exists a next combination.
 */

public class IteratorForCombination {
    private Deque<String> combinations = new ArrayDeque<>();
    private String characters;
    private int n, k;

    private void backtrack(int first, StringBuilder curr) {
        // if the combination is done
        if (curr.length() == k) {
            combinations.push(curr.toString());
            // speed up by non-constructing combinations
            // with more than k elements
            return;
        }

        for (int i = first; i < n; ++i) {
            // add i into the current combination
            curr.append(characters.charAt(i));
            // use next integers to complete the combination
            backtrack(i + 1, curr);
            // backtrack
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public IteratorForCombination(String characters, int combinationLength) {
        this.n = characters.length();
        this.k = combinationLength;
        this.characters = characters;
        backtrack(0, new StringBuilder());
    }

    public String next() {
        return combinations.removeLast();
    }

    public boolean hasNext() {
        return (!combinations.isEmpty());
    }
}
