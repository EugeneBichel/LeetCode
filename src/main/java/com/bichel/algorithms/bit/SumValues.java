package com.bichel.algorithms.bit;

public class SumValues {
    private int getSum(int a, int b) {
        int result = a ^ b;
        int carry = (a & b) << 1;

        while (carry != 0) {
            a = result ^ carry;
            b = (result & carry) << 1;

            result = a;
            carry = b;
        }

        return a;
    }
}
