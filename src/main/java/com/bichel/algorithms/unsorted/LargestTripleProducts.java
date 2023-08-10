package com.bichel.algorithms.unsorted;

import java.util.Arrays;

/*
You're given a list of n integers arr[0..(n-1)].
You must compute a list output[0..(n-1)] such that,
for each index i (between 0 and n-1, inclusive),
output[i] is equal to the product of the three largest elements out of arr[0..i]
(or equal to -1 if i < 2, as arr[0..i] then includes fewer than three elements).
Note that the three largest elements used to form any product
may have the same values as one another, but they must be at different indices in arr.

Return a list of n integers output[0..(n-1)], as described above.

Example 1
n = 5
arr = [1, 2, 3, 4, 5]
output = [-1, -1, 6, 24, 60]
The 3rd element of output is 3*2*1 = 6, the 4th is 4*3*2 = 24, and the 5th is 5*4*3 = 60.

 */

public class LargestTripleProducts {
    int[] findMaxProduct(int[] arr) {

        int[] max = new int[3];
        int[] ans = new int[arr.length];
        ans[0] = -1;
        ans[1] = -1;

        max[0] = arr[0];
        max[1] = arr[1];
        max[2] = arr[2];
        Arrays.sort(max);

        ans[2] = max[0] * max[1] * max[2];

        for (int i = 3; i < arr.length; i++) {
            max[0] = Math.max(arr[i], max[0]);
            Arrays.sort(max);
            ans[i] = max[0] * max[1] * max[2];
        }

        return ans;
    }
}
