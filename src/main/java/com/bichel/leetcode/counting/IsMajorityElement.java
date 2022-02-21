package com.bichel.leetcode.counting;

/*
Given an integer array nums sorted in non-decreasing order and an integer target,
return true if target is a majority element, or false otherwise.

A majority element in an array nums is an element
that appears more than nums.length / 2 times in the array.
 */

public class IsMajorityElement {
    public boolean isMajorityElement(int[] nums, int target) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) counter++;
        }

        return counter > nums.length / 2;
    }
}
