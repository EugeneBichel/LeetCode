package com.bichel.algorithms.problemsheap.search;

/*
Given a positive integer num, write a function which
returns True if num is a perfect square else False.

Follow up: Do not use any built-in library function such as sqrt.

Time complexity : O(logN)
Space complexity : O(1)
 */

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {

        if (num == 1) return true;

        long l = 2;
        long r = num / 2;

        while (l <= r) {
            long pivot = l + (r - l) / 2;

            long product = pivot * pivot;

            if (product > num) r = pivot - 1;
            else if (product < num) l = pivot + 1;
            else return true;
        }

        return r * r == num;
    }
}
