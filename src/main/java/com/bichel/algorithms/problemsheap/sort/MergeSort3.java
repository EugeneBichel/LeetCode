package com.bichel.algorithms.problemsheap.sort;

public class MergeSort3 {
    public static void sort(Comparable[] arr) {

        int N = arr.length;

        mergeSort(arr, 0, N-1);
    }

    private static void mergeSort(Comparable[] arr, int left, int right) {
        if(left >= right) {
            return;
        }

        int middle = (left + right) / 2;

        mergeSort(arr, left, middle);

        mergeSort(arr, middle + 1, right);

        merge(arr, left, middle, right);
    }

    private static void merge(Comparable[] arr, int left, int  middle, int right) {

        int n1 = middle + 1 - left;
        int n2 = right - middle;
        Comparable[] leftArr = new Comparable[n1];
        Comparable[] rightArr = new Comparable[n2];

        for(int i = 0; i < n1; i++) {
            leftArr[i] = arr[i + left];
        }

        for(int j = 0; j < n2; j++) {
            rightArr[j] = arr[j + middle + 1];
        }

        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = left;

        while (leftIndex < n1 && rightIndex < n2) {
            if(Utility.less(leftArr[leftIndex], rightArr[rightIndex]) == true) {
                arr[resultIndex]=leftArr[leftIndex++];
            } else {
                arr[resultIndex]=rightArr[rightIndex++];
            }

            resultIndex++;
        }
        while(leftIndex < n1) {
            arr[resultIndex++] = leftArr[leftIndex++];
        }

        while(rightIndex < n2) {
            arr[resultIndex++] = rightArr[rightIndex++];
        }
    }
}
