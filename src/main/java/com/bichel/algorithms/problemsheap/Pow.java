package com.bichel.algorithms.problemsheap;

/*
Implement pow(x, n), which calculates x raised to the power n (i.e., x^n)

Time complexity : O(logn). n is reduced by half.
Thus we need at most O(logn) computations to get the result.

Space complexity : O(logn). For each computation, we need to store the result
We need to do the computation for O(logn) times,
so the space complexity is O(logn).
 */

public class Pow {
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n *= -1;
        }

        return fastPow(x, n);
    }

    private double fastPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPowIterate(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n *= -1;
        }

        double ans = 1;
        double product = x;

        for (long i = n; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans *= product;
            }

            product = product * product;
        }

        return ans;
    }
}
