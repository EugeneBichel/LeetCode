package com.bichel.algorithms.problemsheap.sort.basic;

import com.bichel.algorithms.problemsheap.sort.Utility;

public class Selection {
    public static void sort(Comparable[] a) {
        int N = a.length;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {

                if (Utility.less(a[j], a[i]) == true) {
                    Utility.exch(a, i, j);
                }

                Utility.print(a);
            }
        }
    }
}
