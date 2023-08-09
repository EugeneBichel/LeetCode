package com.bichel.algorithms.problemsheap.strings;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String str = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {

                if (isPalindrome(s, i, j)) {
                    String s1 = s.substring(i, j + 1);
                    if (s1.length() > str.length())
                        str = s1;
                }
            }
        }

        return str;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }

        return true;
    }
}
