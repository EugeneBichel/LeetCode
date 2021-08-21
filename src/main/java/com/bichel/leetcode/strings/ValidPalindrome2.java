package com.bichel.leetcode.strings;

public class ValidPalindrome2 {
    public static void main(String[] args) {
        ValidPalindrome2 program = new ValidPalindrome2();

        String s1 = "aba";
        String s2 = "abca";
        String s3 = "abc";
        String s4 = "eccer";
        String s5= "cxcaac";

        program.validPalindrome(s5);
    }

    private boolean isPalindrome(String s, int l, int r) {

        char[] a = s.toCharArray();

        while(l < r) {
            if(a[l++] != a[r--]) {
                return false;
            }
        }

        return true;
    }

    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        char[] a = s.toCharArray();

        while(l < r) {
            if(a[l] != a[r]) {
                return isPalindrome(s, l+1, r) || isPalindrome(s, l, r-1);
            }

            l++;
            r--;
        }

        return true;
    }
}
