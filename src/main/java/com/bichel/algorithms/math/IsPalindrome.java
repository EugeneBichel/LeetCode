package com.bichel.algorithms.math;

public class IsPalindrome {
    public static void main(String[] args) {

    }

    public boolean isPalindrome2(int x) {
        String str = String.valueOf(x);

        int l = 0;
        int r = str.length()-1;

        while(l < r) {
            if(str.charAt(l++) != str.charAt(r--)) return false;
        }

        return true;
    }

    public boolean isPalindrome(int x) {
        if(x==0) return true;

        StringBuilder sb = new StringBuilder();
        int source = x;

        while(x > 0) {
            sb.append(x % 10);
            x /= 10;
        }

        if(source < 0) sb.append('-');

        return String.valueOf(source).equals(sb.toString());
    }
}
