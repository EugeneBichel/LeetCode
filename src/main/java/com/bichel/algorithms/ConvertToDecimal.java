package com.bichel.algorithms;

public class ConvertToDecimal {
    public static void main(String[] args) {

        System.out.println(toDecimal(11,2));
        System.out.println(toDecimal(111,2));
        System.out.println(toDecimal(1000,2));
        System.out.println(toDecimal(1111,2));
        System.out.println(toDecimal(10000,2));
    }

    private static int toDecimal(int n, int b) {
        int result = 0;
        int multiplier = 1;

        while(n > 0) {
            int x = n % 10;
            result += x * multiplier;
            multiplier *= b;
            n /= 10;
        }

        return result;
    }
}
