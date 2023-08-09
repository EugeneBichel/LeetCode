package com.bichel.algorithms.problemsheap.math;

/*
Implement the myAtoi(string s) function,
which converts a string to a 32-bit signed integer
(similar to C/C++'s atoi function).
 */

public class ConvertStringToNumber {
    public int myAtoi(String input) {
        int sign = 1;
        int result = 0;
        int index = 0;
        int n = input.length();

        while (index < n && input.charAt(index) == ' ') {
            index++;
        }

        if (index < n && input.charAt(index) == '-') {
            sign = -1;
            index++;
        }

        while (index < n && Character.isDigit(input.charAt(index))) {
            int digit = input.charAt(index) - '0';

            if ((result > Integer.MAX_VALUE / 10) ||
                    (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                // If integer overflowed return 2^31-1, otherwise if underflowed return -2^31.
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = 10 * result + digit;
            index++;
        }

        return sign * result;
    }
}
