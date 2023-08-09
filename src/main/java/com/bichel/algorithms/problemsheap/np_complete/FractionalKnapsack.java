package com.bichel.algorithms.problemsheap.np_complete;

import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        sort(values, weights);
        int N = values.length;
        double result = 0;

        for(int i = 0; i < N && capacity > 0; i++) {
            if(weights[i] <= capacity) {
                result += values[i];
                capacity -= weights[i];
            } else {
                result += ((double)values[i] / (double)weights[i]) * capacity;
                capacity -= capacity;
            }
        }

        return result;
    }

    private static void sort(int[] values, int[] weights) {
        int N = values.length;

        for(int i = 1; i < N; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if((double)values[j] / (double)weights[j] < (double)values[j+1] / (double)weights[j+1]) {
                    swap(values, j, j+1);
                    swap(weights, j, j+1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
