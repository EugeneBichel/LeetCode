package com.bichel.leetcode.backtracking;

/*
ou are given an array of transactions where
transactions[i] = [fromi, toi, amounti] indicates that the person
with ID = fromi gave amounti $ to the person with ID = toi.

Return the minimum number of transactions required to settle the debt.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class OptimalAccountBalancing {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int[] t : transactions) {
            m.put(t[0], m.getOrDefault(t[0], 0) - t[2]);
            m.put(t[1], m.getOrDefault(t[1], 0) + t[2]);
        }
        return settle(0, new ArrayList<>(m.values()));
    }

    private int settle(int start, List<Integer> debt) {
        while (start < debt.size() && debt.get(start) == 0)
            start++;

        if (start == debt.size())
            return 0;

        int r = Integer.MAX_VALUE;
        for (int i = start + 1; i < debt.size(); i++) {
            if (debt.get(start) * debt.get(i) < 0) {
                debt.set(i, debt.get(i) + debt.get(start));
                r = Math.min(r, 1 + settle(start + 1, debt));
                debt.set(i, debt.get(i) - debt.get(start));
            }
        }

        return r;
    }
}
