package com.bichel.algorithms.problemsheap;

import java.util.Arrays;

public class ContiguousSubarrays {
    public int[] countSubarrays(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return new int[0];
        }

        int[] res = new int[arr.length];
        Arrays.fill(res, 1);

        for (int i = 0; i < arr.length; i++) {
            res[i] += countSubarrays(arr, i, 1);
            res[i] += countSubarrays(arr, i, -1);
        }
        return res;
    }

    private int countSubarrays(int[] a, int i, int step) {
        int s = 0;
        int m = a[i];
        i += step;

        while (i >= 0 && i < a.length) {
            if (a[i] < m)
                s++;
            else
                break;

            i += step;
        }

        return s;
    }
}
