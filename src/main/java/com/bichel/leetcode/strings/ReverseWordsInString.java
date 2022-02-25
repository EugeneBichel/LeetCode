package com.bichel.leetcode.strings;

/*
"t", "h", "e", " ", "s", "k", "y", " ", "i", "s", " ", "b", "l", "u", "e"
the sky is blue

1. find words and reverse them
eht yks si eulb

2. reverse a full sentence
blue is sky the
 */

public class ReverseWordsInString {
    public String[] reverseWords(String[] s) {

        if (s.length == 0)
            return s;

        int start = 0;

        for (int i = 0; i < s.length; i++) {
            if (s[i].equals(" ")) {
                s = reverse(s, start, i - 1);
                start = i + 1;
            }
        }

        //reverse last word
        s = reverse(s, start, s.length - 1);

        //reverse all string
        s = reverse(s, 0, s.length - 1);

        return s;
    }

    private String[] reverse(String[] s, int start, int end) {

        String temp;

        while (start < end) {
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }

        return s;
    }
}
