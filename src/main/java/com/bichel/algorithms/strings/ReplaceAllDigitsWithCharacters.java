package com.bichel.algorithms.strings;

/*
You are given a 0-indexed string s that has lowercase English letters
in its even indices and digits in its odd indices.

There is a function shift(c, x), where c is a character and x is a digit,
that returns the xth character after c.

For example, shift('a', 5) = 'f' and shift('x', 0) = 'x'.
For every odd index i, you want to replace the digit s[i] with shift(s[i-1], s[i]).
 */

public class ReplaceAllDigitsWithCharacters {
    public String replaceDigits(String s) {
        char[] res = s.toCharArray();
        for (int i = 1; i < s.length(); i += 2) {
            res[i] = (char)(res[i - 1] + res[i] - '0');
        }
        return String.valueOf(res);
    }
}
