package com.bichel.algorithms.unsorted;

import java.util.LinkedList;
import java.util.Queue;

/*
or example, to encrypt the string "abc", we first take "b", and then append the encrypted version of "a" (which is just "a") and the encrypted version of "c" (which is just "c") to get "bac".
If we encrypt "abcxcba" we'll get "xbacbca". That is, we take "x" and then append the encrypted version "abc" and then append the encrypted version of "cba".
Input
S contains only lower-case alphabetic characters
1 <= |S| <= 10,000
Output
Return string R, the encrypted version of S.
Example 1
S = "abc"
R = "bac"
Example 2
S = "abcd"
R = "bacd"
Example 3
S = "abcxcba"
R = "xbacbca"
Example 4
S = "facebook"
R = "eafcobok"
 */

public class EncryptedWords {
    String findEncryptedWord(String s) {
        StringBuilder sb = new StringBuilder();
        Queue<String> q = new LinkedList<>();

        int n = s.length();
        int pivot = n % 2 == 1 ? n / 2 : n / 2 - 1;

        sb.append(s.charAt(pivot));

        q.add(s.substring(0, pivot));
        q.add(s.substring(pivot + 1, n));

        while (!q.isEmpty()) {

            String str = q.poll();

            if (str.length() <= 1) {
                sb.append(str);
                continue;
            }

            pivot = str.length() % 2 == 1 ? str.length() / 2 : str.length() / 2 - 1;
            int l = 0;
            int r = str.length() - 1;

            sb.append(str.charAt(pivot));

            if (pivot > 1)
                q.add(str.substring(l, pivot));
            else sb.append(str, l, pivot);

            if (pivot + 1 < r)
                q.add(str.substring(pivot + 1, r + 1));
            else if (pivot + 1 <= r)
                sb.append(str, pivot + 1, r + 1);
        }

        return sb.toString();
    }
}
