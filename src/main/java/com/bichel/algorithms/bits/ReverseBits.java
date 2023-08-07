package com.bichel.algorithms.bits;

public class ReverseBits {
    public int reverseBits(int n) {
        int ans = 0;
        int power = 31;

        while(n != 0) {
            ans += (n & 1) << power;
            n = n >>> 1;
            power -= 1;
        }

        return ans;
    }
}
