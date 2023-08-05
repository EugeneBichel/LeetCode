package com.bichel.algorithms.sort;

public class Bubble {
    public static void sort(Comparable[] arr) {
        int N = arr.length;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N-i-1; j++) {
                if(Utility.less(arr[j+1], arr[j])) {
                    Utility.exch(arr, j, j+1);
                }
            }
        }
    }
}
