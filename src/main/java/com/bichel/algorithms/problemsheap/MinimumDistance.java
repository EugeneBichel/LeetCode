package com.bichel.algorithms.problemsheap;

/*
Given a string A which contains only three characters {'x', 'o', '.'}.

Find minimum possible distance between any pair of 'x' and 'o' in the string.

Distance is defined as the absolute difference between the index of 'x' and 'o'.

NOTE: If there is no such pair return -1.
 */

public class MinimumDistance {
    public int solve(String A) {

        int min = Integer.MAX_VALUE;
        int iX = -1;
        int iO = -1;

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'x' || A.charAt(i) == 'o') {
                if (A.charAt(i) == 'x') iX = i;
                else if (A.charAt(i) == 'o') iO = i;

                if (iX == -1 || iO == -1) continue;

                min = Math.min(min, Math.abs(iX - iO));
            }
        }

        if (min == Integer.MAX_VALUE) return -1;

        return min;
    }
}
