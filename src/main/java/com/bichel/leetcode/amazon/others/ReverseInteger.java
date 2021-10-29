package com.bichel.leetcode.amazon.others;

public class ReverseInteger {
    public int reverse(int x) {
        long rev = 0;

        int sign = 1;
        if (x < 0) sign = -1;

        x = Math.abs(x);

        int i = 0;
        while (x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }

        rev *= sign;

        if (rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE) return 0;

        return (int) rev;
    }
}
