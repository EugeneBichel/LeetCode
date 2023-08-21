package com.bichel.algorithms.problemsheap.strings;

/*
Given a string s,
check if it can be constructed by taking a substring of it
and appending multiple copies of the substring together.

Example 1:
Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.
 */

public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                StringBuilder pattern = new StringBuilder();
                for (int j = 0; j < n / i; j++) {
                    pattern.append(s.substring(0, i));
                }
                if (s.equals(pattern.toString())) {
                    return true;
                }
            }
        }

        return false;
    }
}
