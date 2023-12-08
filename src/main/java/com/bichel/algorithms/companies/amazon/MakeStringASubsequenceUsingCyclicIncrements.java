package com.bichel.algorithms.companies.amazon;

public class MakeStringASubsequenceUsingCyclicIncrements {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, j = 0, n = str1.length(), m = str2.length();
        while (i < n && j < m) {
            char ch = str1.charAt(i), ch2 = str2.charAt(j);
            if (ch == ch2 || (ch + 1 == ch2) || ch - 25 == ch2) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == m;
    }
}
