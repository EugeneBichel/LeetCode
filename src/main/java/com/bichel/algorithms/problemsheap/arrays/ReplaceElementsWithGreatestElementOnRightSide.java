package com.bichel.algorithms.problemsheap.arrays;

/*
Given an array arr, replace every element in that array with the greatest element
among the elements to its right, and replace the last element with -1.

After doing so, return the array.
 */

public class ReplaceElementsWithGreatestElementOnRightSide {
    public int[] replaceElements(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            max = Integer.MIN_VALUE;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > max)
                    max = arr[j];
            }

            arr[i] = max;

        }

        arr[arr.length - 1] = -1;

        return arr;
    }
}
