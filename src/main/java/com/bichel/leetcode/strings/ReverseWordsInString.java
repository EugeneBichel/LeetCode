package com.bichel.leetcode.strings;

public class ReverseWordsInString {
    public static void main(String[] args) {
        String[] s = {"t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"};

        String[] res = reverseWords(s);

        StringBuilder sb=new StringBuilder();
        for(String ch: res) sb.append(ch);

        System.out.println(sb.toString());
    }

    private static String[] reverse(String[] s, int start, int end) {

        String temp;

        while(start < end) {
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }

        return s;
    }

    private static String[] reverseWords(String[] s) {

        if(s.length == 0) return s;

        int start = 0;

        for(int i=0; i<s.length; i++) {
            if(s[i].equals(" ")) {
                s = reverse(s, start, i-1);
                start = i+1;
            }
        }

        //reverse last word
        s = reverse(s, start, s.length - 1);

        //reverse all string
        s = reverse(s, 0, s.length - 1);

        return s;
    }
}
