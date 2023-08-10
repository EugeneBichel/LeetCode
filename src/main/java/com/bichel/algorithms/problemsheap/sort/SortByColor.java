package com.bichel.algorithms.problemsheap.sort;

/*
Given an array with n objects colored red, white or blue,
sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
Note: Using library sort function is not allowed.

Example :
Input : [0 1 2 0 1 2]
Modify array so that it becomes : [0 0 1 1 2 2]
 */

import java.util.ArrayList;

public class SortByColor {
    public void sortColors(ArrayList<Integer> a) {
        int[] arr = new int[3];
        for (Integer val : a) {
            arr[val]++;
        }

        for (int i = 0; i < a.size(); i++) {
            if (arr[0] > 0) {
                a.set(i, 0);
                arr[0]--;
            } else if (arr[1] > 0) {
                a.set(i, 1);
                arr[1]--;
            } else {
                a.set(i, 2);
                arr[2]--;
            }
        }

    }
}
