package com.bichel.algorithms.sliding_window;

/*
Given a binary array data, return the minimum number of swaps required to group
all 1’s present in the array together in any place in the array.

Example 1:

Input: data = [1,0,1,0,1]
Output: 1
Explanation: There are 3 ways to group all 1's together:
[1,1,1,0,0] using 1 swap.
[0,1,1,1,0] using 2 swaps.
[0,0,1,1,1] using 1 swap.
The minimum is 1.
 */

import java.util.Arrays;

public class MinimumSwapsToGroupAll1Together {
    public int minSwaps(int[] data) {
        //Input: data = [1,0,1,0,1]
        int ones = Arrays.stream(data).sum(); //3

        int numOnes = 0;
        int maxOnes = 0;

        int left = 0;
        int right = 0;

        /*
        Input: data = [1,0,1,0,1]
        Output: 1
        Explanation: There are 3 ways to group all 1's together:
        [1,1,1,0,0] using 1 swap.
        [0,1,1,1,0] using 2 swaps.
        [0,0,1,1,1] using 1 swap.
        The minimum is 1.
         */

        while(right < data.length) {
            numOnes += data[right++];

            if(right - left > ones) {
                numOnes -= data[left++];
            }

            maxOnes = Math.max(maxOnes, numOnes);
        }

        return ones - maxOnes;
    }
}
