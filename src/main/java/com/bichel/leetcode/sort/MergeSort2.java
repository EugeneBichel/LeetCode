package com.bichel.leetcode.sort;

public class MergeSort2 {
    public static void main(String[] args) {

        int[] arr = {3, 2, 4, 1, 8, 5, 6, 0, 9, 7};

        sort(arr);

        for(int item: arr) {
            System.out.print(item + " ");
        }
    }

    private static void sort(final int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static int[] mergeSort(final int[] arr, int l, int r) {
        if(l >= r) {
            return arr;
        }

        //int middle = (l+r) / 2;
        int middle = (l+r) >>> 2;

        mergeSort(arr, l, middle);
        mergeSort(arr, middle + 1, r);

        System.out.println(String.format("l = %s; r = %s", l , r));

        return merge(arr, l, middle, r);
    }

    private static int[] merge(int[] arr, int l, int middle, int r) {

        int[] arr1 = new int[middle + 1 - l];
        int[] arr2 = new int[r - middle];

        for(int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[l + i];
        }

        for(int i = 0; i < arr2.length; i++) {
            arr2[i] = arr[middle + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                arr[k] = arr1[i];
                i++;
            } else {
                arr[k] = arr2[j];
                j++;
            }

            k++;
        }

        while(i < arr1.length) {
            arr[k++] = arr1[i++];
        }

        while(j < arr2.length) {
            arr[k++] = arr2[j++];
        }

        for(int item: arr) {
            System.out.print(item + " ");
        }

        System.out.println();

        return arr;
    }
}
