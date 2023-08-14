package com.bichel.algorithms.problemsheap.sort.quicksort;

import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {

        int m1 = l;
        int m2 = r;

        if (r - l <= 1) {
            if (a[r] < a[l]) {
                exch(a, r, l);
            }

            int[] m = {m1, m2};
            return m;
        }

        int mid = l;
        int pivot = a[r];

        while (mid <= r) {
            if (a[mid] == pivot) {
                mid++;
            } else if (a[mid] <= pivot) {
                exch(a, l, mid);
                l++;
                mid++;
            } else if (a[mid] > pivot) {
                exch(a, mid, r);
                r--;
            }
        }

        m1 = l - 1;
        m2 = mid;
        int[] m = {m1, m2};
        return m;
    }

    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
        //int m = partition2(a, l, r);
        int[] m = partition3(a, l, r);
        randomizedQuickSort(a, l, m[0]);
        randomizedQuickSort(a, m[1], r);
    }
}
