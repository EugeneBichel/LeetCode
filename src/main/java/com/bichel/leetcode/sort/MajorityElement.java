package com.bichel.leetcode.sort;

import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        //write your code here
        a = quickSort(a, left, right - 1);

        int temp = a[0];
        int counter = 1;
        int N = a.length;
        int pivot = N / 2;

        for(int i = 1; i < N; i++) {
            if(temp == a[i]) {
                counter++;
            } else {
                if(counter > pivot) {
                    return 1;
                } else {
                    counter = 1;
                    temp = a[i];
                }
            }
        }

        return -1;
    }

    private static int[] quickSort(int[] a, int left, int right) {
        if(right <= left) {
            return a;
        }

        int pivot = partition(a, left, right);

        quickSort(a, left, pivot - 1);
        quickSort(a, pivot + 1, right);

        return a;
    }

    private static int partition(int[] a, int left, int right) {
        int x = a[right];
        int i = left - 1;

        for(int j = left; j < right; j++) {
            if(a[j] <= x) {
                i++;
                swap(a, i, j);
            }
        }

        swap(a, i+1, right);

        return i+1;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

