package com.bichel.leetcode.sort;

public class Qsort1 {
    public static void main(String[] args) {
        int[] a = {3, 1, 5, 9, 2, 7, 4, 6, 8};

        qsort1(a, 0, a.length - 1);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private static void qsort1(int[] a, int l, int r) {
        if(l >= r) {
            return;
        }

        int p = l;
        for(int i = l + 1; i < r; i++) {
            if(a[i] <= a[l]) {
                p++;
                int temp = a[p];
                a[p] = a[i];
                a[i] = temp;
            }
        }

        int temp = a[l];
        a[l] = a[p];
        a[p] = temp;

        qsort1(a, l, p-1);
        qsort1(a, p+1, r);
    }
}