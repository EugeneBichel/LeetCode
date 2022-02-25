package com.bichel.facebook;

/*
Implement next permutation, which rearranges numbers into
the lexicographically next greater permutation of numbers.

[1,2,3] -> [1,2,3], [1,3,2], [3,1,2], [3,2,1]

If such an arrangement is not possible, it must rearrange it
as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

Lexicographically means next number is greater than the prev.
[3,2,1] - means we can't form a number greater than the current number from
        all the possible permutations
 */

/*
Permutation means rearranging a set of given objects in all the possible orders.
The number of possible permutations is n! = 1*2*3*(n-2)*(n-1)*n

There are many ways to systematically generate all permutations of a given sequence.
One classic algorithm is based upon finding the next permutation in lexicographical/
dictionary/alphabetical order

Steps:
1 move from right end and try to find the 1st decreasing element
2

 */

public class NextPermutation {
    public void nextPermutation(int[] nums) {

        //find first decreasing element from right end
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        //if the element exists
        if (i >= 0) {
            //find first element from right end, which is greater than nums[i]
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }

            //swap items
            swap(nums, i, j);
        }

        reverse(nums, i + 1);
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
