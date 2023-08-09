package com.bichel.algorithms.problemsheap;

/*
Implement strStr().

strstr - locate a substring ( needle ) in a string ( haystack ).

Example 1:
Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:
Input: haystack = "aaaaa", needle = "bba"
Output: -1

Example 3:
Input: haystack = "", needle = ""
Output: 0
 */

public class ImplementStrStr {
    public int strStr(String str1, String str2) {
        if (str1.length() == 0 && str2.length() == 0)
            return 0;
        if (str2.length() == 0)
            return 0;
        if (str2.length() > str1.length())
            return -1;

        char[] s = str1.toCharArray();
        char[] a = str2.toCharArray();

        int start = -1;

        for (int i = 0; i < s.length; i++) {

            int left = i;
            int k = 0;
            while (k < a.length && left < s.length) {
                if (s[left] != a[k]) {
                    break;
                }

                k++;
                left++;
            }

            if (k == a.length) {
                start = i;
                break;
            }
        }

        return start;
    }

    public int strStrUsingSubstring(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (n == 0) {
            return 0;
        }
        if (n > m) {
            return -1;
        }

        for (int i = 0; i < m - n + 1; i++) {
            if (haystack.substring(i, i + n).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
