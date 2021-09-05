package com.bichel.leetcode.strings;

/*
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters.
The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or
multiple spaces between two words.
The returned string should only have a single space separating the words.
Do not include any extra spaces.
 */

public class ReverseWordsinaString {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == ' ' && s.charAt(i) == ' ') continue;
            sb.append(s.charAt(i));
        }

        s = sb.toString();

        int N = s.length();
        char[] a = new char[N];

        for (int i = 0; i < N; i++) a[i] = s.charAt(i);

        int l = 0;
        int r = N - 1;
        while (l < r) {
            char t = a[l];
            a[l] = a[r];
            a[r] = t;

            l++;
            r--;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(a[i]);
        }

        for (int i = 0; i < N; ) {
            l = i;
            r = i + 1;

            while (r < N && a[r++] != ' ') ;

            int j = r - 1;
            if (a[j] == ' ') {
                j--;
            }

            while (i < j) {
                char t = a[i];
                a[i++] = a[j];
                a[j--] = t;
            }

            i = r;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < N; i++) ans.append(a[i]);

        return ans.toString();
    }
}
