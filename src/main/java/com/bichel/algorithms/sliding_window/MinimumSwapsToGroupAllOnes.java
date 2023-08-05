package com.bichel.algorithms.sliding_window;

/*
Given a binary array data,
return the minimum number of swaps required to group all 1’s
present in the array together in any place in the array.
 */

import java.util.Arrays;

public class MinimumSwapsToGroupAllOnes {
    public int minSwaps(int[] data) {
        int ones = Arrays.stream(data).sum();
        int cntOne = 0, maxOne = 0;
        int left = 0, right = 0;

        while (right < data.length) {
            // updating the number of 1's by adding the new element
            cntOne += data[right++];

            // maintain the length of the window to ones
            if (right - left > ones) {
                // updating the number of 1's by removing the oldest element
                cntOne -= data[left++];
            }

            // record the maximum number of 1's in the window
            maxOne = Math.max(maxOne, cntOne);
        }

        return ones - maxOne;
    }
}
