package com.bichel.algorithms.problemsheap.strings;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

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

        return prefix.substring(0, len);
    }
}
