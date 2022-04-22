package com.bichel.other.Sorts;

public class QuickSort {
    public static void sort(Comparable[] arr) {
        int N = arr.length;

        quickSort(arr, 0, N-1);
    }

    private static void quickSort(Comparable[] arr, int l , int r) {
        if(l >= r) {
            return;
        }

        int pivot = partition(arr, l, r);

        quickSort(arr, l, pivot - 1);
        quickSort(arr, pivot + 1, r);
    }

    private static int partition(Comparable[] arr, int left, int right) {
        int pivot = right;

        int i = left;
        int j = right;

        do {
            while (Utility.less(arr[i], arr[pivot]) && i < pivot) {
                i++;
            }

            while (Utility.less(arr[pivot], arr[j]) && j > pivot) {
                j--;
            }

            Utility.exch(arr, i, j);

        }while(i < j);

        return pivot;
    }
}
