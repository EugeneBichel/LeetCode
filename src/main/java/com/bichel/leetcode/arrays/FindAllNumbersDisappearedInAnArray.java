package com.bichel.leetcode.arrays;

import java.util.List;
import java.util.ArrayList;

/*
Given an array nums of n integers where nums[i] is in the range [1, n],
return an array of all the integers in the range [1, n] that do not appear in nums.
 */

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] alphabet = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            alphabet[nums[i]]++;
        }

        List<Integer> missedNumbers = new ArrayList<>();
        for (int i = 1; i < alphabet.length; i++) {
            if (alphabet[i] == 0)
                missedNumbers.add(i);
        }

        return missedNumbers;
    }
}
