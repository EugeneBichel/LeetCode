package com.bichel.leetcode.bit;

public class SumValues {
    public static void main(String[] args) {
        String a = "11";
        String b = "1";

        int val1 = Integer.parseInt(a, 2);
        int val2 = Integer.parseInt(b, 2);

        SumValues pr = new SumValues();

        Integer res = pr.getSum(val1, val2);

        System.out.println(Integer.toBinaryString(res));
    }

    private int getSum(int a, int b) {
        int result = a^b;
        int carry = (a & b) << 1;

        while(carry != 0) {
            a = result ^ carry;
            b = (result & carry) << 1;

            result = a;
            carry = b;
        }

        return a;
    }
}
