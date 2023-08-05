package com.bichel.algorithms;

public class LongestBuiltPalindromic {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray()) {
            count[c]++;
        }

        int ans = 0;
        for (int numOfCh: count) {
            ans += numOfCh / 2 * 2;

            if (ans % 2 == 0 && numOfCh % 2 == 1) {
                ans++;
            }
        }

        return ans;
    }
}
