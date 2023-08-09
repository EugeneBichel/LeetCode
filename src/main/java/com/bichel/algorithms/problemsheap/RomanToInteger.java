package com.bichel.algorithms.problemsheap;

public class RomanToInteger {
    public int romanToInt(String s) {
        int num = 0;

        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {

            if (c[i] == 'M') {
                num += 1000;
            } else if (c[i] == 'D') {
                num += 500;
            } else if (i + 1 < s.length() && c[i] == 'C' && c[i + 1] == 'D') {
                num += 400;
                i++;
            } else if (i + 1 < s.length() && c[i] == 'C' && c[i + 1] == 'M') {
                num += 900;
                i++;
            } else if (c[i] == 'C') {
                num += 100;
            } else if (c[i] == 'L') {
                num += 50;
            } else if (i + 1 < s.length() && c[i] == 'X' && c[i + 1] == 'L') {
                num += 40;
                i++;
            } else if (i + 1 < s.length() && c[i] == 'X' && c[i + 1] == 'C') {
                num += 90;
                i++;
            } else if (c[i] == 'X') {
                num += 10;
            } else if (c[i] == 'V') {
                num += 5;
            } else if (i + 1 < s.length() && c[i] == 'I' && c[i + 1] == 'V') {
                num += 4;
                i++;
            } else if (i + 1 < s.length() && c[i] == 'I' && c[i + 1] == 'X') {
                num += 9;
                i++;
            } else if (c[i] == 'I') {
                num += 1;
            }
        }

        return num;
    }
}
