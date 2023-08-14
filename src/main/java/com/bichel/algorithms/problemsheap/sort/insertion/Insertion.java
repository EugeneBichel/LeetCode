package com.bichel.algorithms.problemsheap.sort.insertion;

import com.bichel.algorithms.problemsheap.sort.Utility;

public class Insertion {
    public static void sort(Comparable[] arr) {
        int N = arr.length;

        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (Utility.less(arr[j], arr[j - 1]) == true) {
                    Utility.exch(arr, j - 1, j);
                }
            }
        }
    }
}
