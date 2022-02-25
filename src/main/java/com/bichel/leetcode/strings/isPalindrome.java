package com.bichel.leetcode.strings;

public class isPalindrome {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;

        char[] c = s.toCharArray();

        while(l < r) {
            if(c[l++] != c[r--]) {
                return false;
            }
        }

        return true;
    }
}
