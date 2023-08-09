package com.bichel.algorithms.problemsheap.sort;

public class ShellSortTest {

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
