package com.bichel.leetcode.sort;

public class Utility {

    public static boolean less(Comparable currentItem, Comparable currentMin) {
        if(currentItem.compareTo(currentMin) < 0) {
            return true;
        }

        return false;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void print(Comparable[] arr) {
        int N = arr.length;

        for(int i = 0; i < N; i++) {
            System.out.print(arr[i]);
        }

        System.out.println();
    }

    public static void print(int[] arr) {
        int N = arr.length;

        for(int i = 0; i < N; i++) {
            System.out.print(arr[i]);
        }

        System.out.println();
    }
}
