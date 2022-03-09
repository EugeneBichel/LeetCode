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
        int indUpToDown = nums.length - 2;
        while (indUpToDown >= 0 && nums[indUpToDown] >= nums[indUpToDown + 1] ) {
            indUpToDown--;
        }

        if (indUpToDown >= 0) {
            int indNumLargerThanUpToDown = nums.length - 1;
            while (indNumLargerThanUpToDown >= 0 &&
                    nums[indNumLargerThanUpToDown] <= nums[indUpToDown]) {
                indNumLargerThanUpToDown--;
            }

            swap(nums, indUpToDown, indNumLargerThanUpToDown);
        }

        reverse(nums, indUpToDown + 1);
    }

    private void reverse(int[] nums, int start) {
        int l = start;
        int r = nums.length - 1;

        while(l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
