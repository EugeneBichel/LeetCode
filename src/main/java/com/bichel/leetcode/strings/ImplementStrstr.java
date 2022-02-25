package com.bichel.leetcode.strings;

public class ImplementStrstr {
    private static int strStr(String str1, String str2) {
        if(str1.length() == 0 && str2.length() == 0) return 0;
        if(str2.length() == 0) return 0;
        if(str2.length() > str1.length()) return -1;

        char[] s = str1.toCharArray();
        char[] a = str2.toCharArray();

        int start = -1;

        for(int i=0; i < s.length; i++) {

            int left = i;
            int k=0;
            while(k < a.length && left < s.length ) {
                if(s[left] != a[k]){
                    break;
                }

                k++;
                left++;
            }

            if(k == a.length) {
                start = i;
                break;
            }
        }

        return start;
    }
}
