package com.bichel.algorithms.problemsheap;

/*
Given an array ‘A’ of sorted integers and another non negative integer k,
find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

Example:

Input :

    A : [1 3 5]
    k : 4
Output : YES

as 5 - 1 = 4

Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Diffk {
    public int diffPossible(ArrayList<Integer> a, int b) {
        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < a.size(); i++)
            m.put(a.get(i), i);

        for (int i = 0; i < a.size(); i++) {
            if (m.containsKey(b + a.get(i)) && m.get(b + a.get(i)) != i) return 1;
        }

        return 0;
    }
}
