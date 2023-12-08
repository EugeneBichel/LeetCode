package com.bichel.algorithms.problemsheap.bits.easy;

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

    public static class NumberOf1Bits {
        /*
        The solution is straight-forward.
        We check each of the 32 bits of the number.
        If the bit is 1, we add one to the number of 1-bits.
         */
        public int hammingWeight(int n) {
            int bits = 0;

            int mask = 1;
            for (int i = 0; i < 32; i++) {
                if ((n & mask) != 0) {
                    bits++;
                }

                mask <<= 1;
            }

            return bits;
        }

        public int hammingWeight2(int n) {
            int num = 0;
            while (n != 0) {
                num++;
                n &= n - 1;
            }

            return num;
        }
    }
}
