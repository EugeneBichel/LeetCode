package com.bichel.algorithms.sort;

public class QuickSort2 {

    public static void main(String[] args) {

        int[] arr = {2, 1, 5, 3, 7, 6, 8, 4, 0, 5, 9};

        int[] sortedArr = quickSort(arr, 0, arr.length - 1);

        for (int item : sortedArr) {
            System.out.print(item + " ");
        }
    }

    private static int[] quickSort(final int[] arr, int l, int r) {

        if (r - l < 2) {
            return arr;
        }

        int pivot = partition(arr, l, r);
        quickSort(arr, l, pivot);
        quickSort(arr, pivot + 1, r);

        return arr;
    }

    private static int partition(final int[] arr, int l, int r) {

        /**
         *  1) pivot is left
         *  2) pivot is right
         *  3) pivot is random
         *  4) pivot is middle. What is middle? What if N mod 2 == 0 than what if middle?
         */

        //Math.floor()

        int pivot = l + (int)(Math.random()*(r-l) + 1);
        //int pivot = l;

        int first = l - 1;
        int last = r + 1;

        while(true) {
            do {
                first++;
            } while (arr[first] < arr[pivot]);

            do {
                last--;
            } while (arr[last] > arr[pivot]);

            if(first >= last) {
                return last;
            }

            int temp = arr[first];
            arr[first] = arr[last];
            arr[last] = temp;
        }
    }
}
