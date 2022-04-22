package com.bichel.other.Other;

import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(long[] numbers) {
        int n = numbers.length;

        int maxIndex1 = 0;
        int maxIndex2 = -1;

        for (int i = 1; i < n; i++) {
            if(numbers[i] > numbers[maxIndex1]) {
                maxIndex1 = i;
            }
        }

        for (int j = 0; j < n; j++) {
            if(maxIndex1 == j) {
                continue;
            }

            if((maxIndex2 != -1 && numbers[maxIndex2] < numbers[j]) || maxIndex2 == -1) {
                maxIndex2 = j;
            }
        }

        return numbers[maxIndex1] * numbers[maxIndex2];
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
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