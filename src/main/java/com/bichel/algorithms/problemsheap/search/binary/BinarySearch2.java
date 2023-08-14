package com.bichel.algorithms.problemsheap.search.binary;

public class BinarySearch2 {

    static int binarySearch(int[] a, int left, int right, int x) {

        if (left > right) {
            return -1;
        }

        if (left == right && a[left] != x) {
            return -1;
        }

        if (left == right && a[left] == x) {
            return left;
        }

        int middleIndex = (left + right) / 2;

        if (x == a[middleIndex]) {
            return middleIndex;
        }

        if (x < a[middleIndex]) {
            return binarySearch(a, left, middleIndex, x);
        } else {
            return binarySearch(a, middleIndex + 1, right, x);
        }
    }

    static int binarySearch(int[] a, int x) {
        int left = 0, right = a.length;
        //write your code here

        return binarySearch(a, left, right - 1, x);
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                return i;
            }
        }

        return -1;
    }
}
