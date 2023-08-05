package com.bichel.algorithms.search;

/*
Given a non-negative integer x, compute and return the square root of x.
Since the return type is an integer, the decimal digits are truncated,
and only the integer part of the result is returned.
Note: You are not allowed to use any built-in exponent function or operator,
such as pow(x, 0.5) or x ** 0.5.

 */

public class Sqrt {
    public int mySqrt(int x) {
        if (x < 2)
            return x;

        long num;
        int pivot, left = 2, right = x / 2;

        while (left <= right) {
            pivot = left + (right - left) / 2;

            num = (long) pivot * pivot;

            if (num > x) right = pivot - 1;
            else if (num < x) left = pivot + 1;
            else return pivot;
        }

        return right;
    }
}
