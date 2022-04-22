package com.bichel.other.Sorts;

public class Counting {
    public static int[] sort(int[] arr, int range) {
        int N = arr.length;
        int[] counting = new int[range];

        for(int i = 0; i < N; i++) {
            counting[arr[i]] += 1;
        }

        int index = 0;
        for(int j = 0; j < range; j++) {
            while(counting[j] > 0) {
                arr[index++] = j;
                counting[j] -= 1;
            }
        }

        return arr;
    }
}
