package com.bichel.facebook;

/*
Implement next permutation, which rearranges numbers into
the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it
as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

Complexity Analysis
Time complexity : O(n). In worst case, only two scans of the whole array are needed.
Space complexity : O(1). No extra space is used. In place replacements are done.
 */

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int indIncr = nums.length - 2;

        //first ind with increasing of values
        while (indIncr >= 0 && nums[indIncr + 1] <= nums[indIncr]) {
            indIncr--;
        }

        if (indIncr >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[indIncr]) {
                j--;
            }

            swap(nums, indIncr, j);
        }

        reverse(nums, indIncr + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;

        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
