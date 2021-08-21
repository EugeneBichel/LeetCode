package com.bichel.leetcode.strings;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] a = {"cir","car"};

        String prefix = longestCommonPrefix(a);
    }

    private static String longestCommonPrefix(String[] strs) {

        if(strs.length == 0) return "";

        String prefix = strs[0];
        int len = prefix.length();

        for(int i = 1; i < strs.length; i++) {
            int k = 0;
            for(int j = 0; j < strs[i].length() && j < len; j++) {
                if(prefix.charAt(j) == strs[i].charAt(j)) {
                    k++;
                } else {
                    break;
                }
            }

            len = k;
        }

        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for(char ch: prefix.toCharArray()) {
            if(counter == len) {
                break;
            }
            sb.append(ch);
            counter++;
        }

        return sb.toString();
    }
}
