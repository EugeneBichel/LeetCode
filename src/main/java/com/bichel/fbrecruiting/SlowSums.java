package com.bichel.fbrecruiting;

import java.util.Arrays;

/*
Suppose we have a list of N numbers, and repeat the following operation until we're left with only a single number: Choose any two numbers and replace them with their sum. Moreover, we associate a penalty with each operation equal to the value of the new number, and call the penalty for the entire list as the sum of the penalties of each operation.
For example, given the list [1, 2, 3, 4, 5], we could choose 2 and 3 for the first operation, which would transform the list into [1, 5, 4, 5] and incur a penalty of 5. The goal in this problem is to find the highest possible penalty for a given input.
Signature:
int getTotalTime(int[] arr)
Input:
An array arr containing N integers, denoting the numbers in the list.
 */

public class SlowSums {

    int getTotalTime(int[] arr) {

        Arrays.sort(arr);
        int num = arr[arr.length - 1] + arr[arr.length - 2];
        int max = num;

        for (int i = arr.length - 3; i >= 0; i--) {
            num += arr[i];
            max += num;
        }

        return max;
    }
}
