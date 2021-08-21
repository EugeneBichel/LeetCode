package com.bichel.leetcode.math;

import java.util.ArrayList;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        int res = divideUsingSubtraction(-2147483648, -1);

        System.out.println(res);
    }

    private static int HALF_INT_MIN = -1073741824;// -2**30;
    public int divide(int dividend, int divisor) {

        // Special case: overflow.
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        /* We need to convert both numbers to negatives.
         * Also, we count the number of negatives signs. */
        int negatives = 2;
        if (dividend > 0) {
            negatives--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negatives--;
            divisor = -divisor;
        }

        ArrayList<Integer> doubles = new ArrayList<>();
        ArrayList<Integer> powersOfTwo = new ArrayList<>();

        /* Nothing too exciting here, we're just making a list of doubles of 1 and
         * the divisor. This is pretty much the same as Approach 2, except we're
         * actually storing the values this time. */
        int powerOfTwo = -1;
        while (divisor >= dividend) {
            doubles.add(divisor);
            powersOfTwo.add(powerOfTwo);
            // Prevent needless overflows from occurring...
            if (divisor < HALF_INT_MIN) {
                break;
            }
            divisor += divisor;
            powerOfTwo += powerOfTwo;
        }

        int quotient = 0;
        /* Go from largest double to smallest, checking if the current double fits.
         * into the remainder of the dividend. */
        for (int i = doubles.size() - 1; i >= 0; i--) {
            if (doubles.get(i) >= dividend) {
                // If it does fit, add the current powerOfTwo to the quotient.
                quotient += powersOfTwo.get(i);
                // Update dividend to take into account the bit we've now removed.
                dividend -= doubles.get(i);
            }
        }

        /* If there was originally one negative sign, then
         * the quotient remains negative. Otherwise, switch
         * it to positive. */
        if (negatives != 1) {
            return -quotient;
        }
        return quotient;
    }

    private static int divideUsingMultipleByTwo(int dividend, int divisor) {
        int quotient = 0;

        while(dividend >= divisor) {
            int powOfTwo = 1;
            int value = divisor;

            while(value + value < dividend) {
                powOfTwo++;
                value += value;
            }

            dividend -= value;
            quotient += powOfTwo;
        }

        return quotient;
    }

    // simple by subtraction
    private static int divideUsingSubtraction(int dividend, int divisor) {

        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int quotient = 0;
        int negative = 0;

        if(dividend < 0) {
            negative++;
            dividend = -dividend;
        }

        if(divisor < 0) {
            negative++;
            divisor = -divisor;
        }

        do {
            dividend -= divisor;
            if(dividend >= 0)
                quotient++;
        }while(dividend >= 0);

        if(negative == 1) {
            quotient = -quotient;
        }

        return quotient;
    }
}
