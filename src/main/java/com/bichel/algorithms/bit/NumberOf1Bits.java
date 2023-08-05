package com.bichel.algorithms.bit;

/*
Write a function that takes an unsigned integer
and returns the number of '1' bits it has
(also known as the Hamming weight).

Note:
Note that in some languages, such as Java,
there is no unsigned integer type. In this case,
the input will be given as a signed integer type.
It should not affect your implementation,
as the integer's internal binary representation is the same,
whether it is signed or unsigned.
In Java, the compiler represents the signed integers
using 2's complement notation. Therefore,
in Example 3, the input represents the signed integer. -3.

Example 1:
Input: n = 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011
has a total of three '1' bits.
 */

/*
The run time depends on the number of bits in n.
 Because nn in this piece of code is a 32-bit integer, the time complexity is O(1).

The space complexity is O(1), since no additional space is allocated.
 */

public class NumberOf1Bits {
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
