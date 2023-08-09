package com.bichel.algorithms.problemsheap.strings;

/*
Given an alphanumeric string s, return the second largest numerical digit
that appears in s, or -1 if it does not exist.
An alphanumeric string is a string consisting of lowercase English letters and digits.
 */

public class SecondLargestDigitInAString {
    public int secondHighest(String s) {
        int max = Integer.MIN_VALUE;
        int nextMax = -1;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch) && (ch - '0') > max) {
                nextMax = Math.max(max, nextMax);
                max = ch - '0';
            } else if (Character.isDigit(ch) &&
                    (ch - '0') < max &&
                    (ch - '0') > nextMax) {
                nextMax = ch - '0';
            }
        }

        return nextMax;
    }
}
