package com.bichel.algorithms.problemsheap.sort;

import java.util.Arrays;

/*
You are given an array nums of non-negative integers.
nums is considered special if there exists a number x such that
there are exactly x numbers in nums that are greater than or equal to x.

Notice that x does not have to be an element in nums.

Return x if the array is special, otherwise, return -1.
It can be proven that if nums is special, the value for x is unique.
 */

public class SpecialArrayWithXElementsGreaterThanOrEqualX {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int n = nums.length - i;
            boolean cond1 = n <= nums[i];
            boolean cond2 = (i - 1 < 0) || (n > nums[i - 1]);

            if (cond1 && cond2)
                return n;
        }

        return -1;
    }
}
