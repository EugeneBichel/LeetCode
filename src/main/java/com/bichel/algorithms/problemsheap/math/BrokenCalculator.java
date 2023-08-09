package com.bichel.algorithms.problemsheap.math;

/*
There is a broken calculator that has the integer startValue on its display initially.
In one operation, you can:

multiply the number on display by 2, or
subtract 1 from the number on display.
Given two integers startValue and target, return the minimum number of operations
needed to display target on the calculator.
 */

public class BrokenCalculator {
    public int brokenCalc(int startValue, int target) {
        int ans = 0;
        //if target > startValue, we can mutliply by 2
        while (target > startValue) {
            ans++;
            if (target % 2 == 1)
                target++;
            else
                target /= 2;
        }

        //if startValue > target, then we can only subtract 1 mean startValue - target
        return ans + startValue - target;
    }
}
