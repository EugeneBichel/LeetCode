package com.bichel.algorithms;

/*
Given a string A.

Return the string A after reversing the string word by word.

NOTE:

A sequence of non-space characters constitutes a word.

Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.

If there are multiple spaces between words, reduce them to a single space in the reversed string.
 */

public class ReverseTheString {
    public String solve(String A) {
        A = A.trim();
        int n = A.length();
        StringBuilder sb = new StringBuilder();
        sb.append(A.charAt(0));

        for (int i = 1; i < n; i++) {
            if (A.charAt(i - 1) == ' ' && A.charAt(i) == ' ') continue;
            sb.append(A.charAt(i));
        }

        char[] str = sb.toString().toCharArray();
        n = str.length;

        int start = 0;
        boolean ws = false;
        for (int i = 0; i < n; i++) {
            if (str[i] == ' ' && ws == false) {
                ws = true;
                reverse(str, start, i - 1);
                start = i + 1;
            } else ws = false;
        }

        str = reverse(str, start, n - 1);
        str = reverse(str, 0, n - 1);

        return new String(str);
    }

    private char[] reverse(char[] str, int a, int b) {

        int l = a;
        int r = b;

        while (l < r) {
            char temp = str[l];
            str[l] = str[r];
            str[r] = temp;
            l++;
            r--;
        }

        return str;
    }
}
