package com.bichel.leetcode.combinations_permutations;

/*
Given an input string s and a pattern p,
implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Input: s = "aa", p = "a*"
Output: true

Input: s = "ab", p = ".*"
Output: true

Input: s = "aab", p = "c*a*b"
Output: true

Input: s = "mississippi", p = "mis*is*p*."
Output: false
 */

public class RegularExpressionMatching {
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();

        boolean firstMatch = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (isMatch(text, pattern.substring(2)) ||
                    (firstMatch && isMatch(text.substring(1), pattern)));
        }

        return firstMatch && isMatch(text.substring(1), pattern.substring(1));
    }
}
