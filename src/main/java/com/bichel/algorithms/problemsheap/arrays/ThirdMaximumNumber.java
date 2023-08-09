package com.bichel.algorithms.problemsheap.arrays;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
Given an integer array nums, return the third distinct maximum number in this array.
If the third maximum does not exist, return the maximum number.
 */

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {

        Set<Integer> setNums = new HashSet<>();
        for (int num : nums)
            setNums.add(num);

        int maximum = Collections.max(setNums);

        if (setNums.size() < 3) {
            return maximum;
        }

        setNums.remove(maximum);
        int secondMaximum = Collections.max(setNums);
        setNums.remove(secondMaximum);
        return Collections.max(setNums);
    }
}
