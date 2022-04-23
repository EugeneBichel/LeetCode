package com.bichel.leetcode.sort;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {4, 1, 8, 5, 9, 6, 0, 7, 3, 2};

        sort(arr);

        for (int item : arr) {
            System.out.print(item + " ");
        }
    }

    private static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
}
