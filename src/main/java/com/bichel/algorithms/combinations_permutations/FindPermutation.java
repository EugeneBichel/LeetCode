package com.bichel.algorithms.combinations_permutations;

import java.util.Stack;

/*
A permutation perm of n integers of all the integers in the range [1, n]
can be represented as a string s of length n - 1 where:

s[i] == 'I' if perm[i] < perm[i + 1], and
s[i] == 'D' if perm[i] > perm[i + 1].
Given a string s, reconstruct the lexicographically smallest permutation perm and return it.
 */

public class FindPermutation {
    public int[] findPermutation(String s) {
        int[] res = new int[s.length() + 1];

        Stack<Integer> stack = new Stack<>();
        int j = 0;

        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) == 'I') {
                stack.push(i);
                while (!stack.isEmpty())
                    res[j++] = stack.pop();
            } else
                stack.push(i);
        }

        stack.push(s.length() + 1);

        while (!stack.isEmpty())
            res[j++] = stack.pop();

        return res;
    }
}
