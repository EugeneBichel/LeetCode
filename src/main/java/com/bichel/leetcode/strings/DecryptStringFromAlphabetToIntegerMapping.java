package com.bichel.leetcode.strings;
/*
You are given a string s formed by digits and '#'.
We want to map s to English lowercase characters as follows:

Characters ('a' to 'i') are represented by ('1' to '9') respectively.
Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
Return the string formed after mapping.

The test cases are generated so that a unique mapping will always exist.
 */
public class DecryptStringFromAlphabetToIntegerMapping {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            int firstDigit = Character.getNumericValue(s.charAt(i));

            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                int secondDigit = Character.getNumericValue(s.charAt(i + 1));

                sb.append((char) ('j' + firstDigit * 10 + secondDigit - 10));

                i = i + 2;
            } else {
                sb.append((char) ('a' + firstDigit - 1));
            }
        }

        return sb.toString();
    }
}
