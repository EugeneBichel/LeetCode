package com.bichel.other.Sorts;// a variation of Insertion Sort: allow exchange of far items.

import com.bichel.other.Sorts.Utility;

public class Shell {
    public static void sort(Comparable[] arr) {
        int N = arr.length;

        for(int gap = N / 2; gap > 0; gap /= 2) {

            for(int i = gap; i < N; i++) {
                Comparable temp = arr[i];

                for(int j = i; j >= gap && Utility.less(arr[j], arr[j - gap]); j -= gap){
                    Utility.exch(arr, j - gap, j);
                }
            }

        }
    }
}
