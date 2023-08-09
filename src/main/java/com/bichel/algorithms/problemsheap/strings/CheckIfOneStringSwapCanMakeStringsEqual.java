package com.bichel.algorithms.problemsheap.strings;

/*
You are given two strings s1 and s2 of equal length.
A string swap is an operation where you choose two indices in a string
(not necessarily different) and swap the characters at these indices.

Return true if it is possible to make both strings equal
by performing at most one string swap on exactly one of the strings.
Otherwise, return false.
 */

public class CheckIfOneStringSwapCanMakeStringsEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;

        int n = s1.length();
        int[] chars = new int[26];
        for (int i = 0; i < n; i++) {
            chars[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            chars[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) return false;
        }

        int diff = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                diff++;
        }

        return diff <= 2 ? true : false;
    }
}
