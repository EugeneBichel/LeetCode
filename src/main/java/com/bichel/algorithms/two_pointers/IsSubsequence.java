package com.bichel.algorithms.two_pointers;

/*
Given two strings s and t,
return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string
by deleting some (can be none) of the characters without disturbing
the relative positions of the remaining characters.
(i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int pS = 0;
        int pT = 0;

        while (pS < n && pT < m) {
            if (s.charAt(pS) == t.charAt(pT)) {
                pS += 1;
            }
            pT += 1;
        }

        return pS == n;
    }
}
