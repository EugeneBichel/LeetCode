package com.bichel.leetcode.arrays;

public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        int k = 5;

        int res = findKth(arr, k);
    }

    private static int findKth(int[] arr, int k) {
        int size = arr[arr.length-1] + k;
        int[] full = new int[size];

        for(int i=0;i<size;i++) {
            full[i] = 0;
        }

        for(int i=0;i<arr.length;i++) {
            full[arr[i]-1] = 1;
        }

        int counter = 0;

        for(int i=0;i<size;i++) {
            if(full[i] == 0) {
                counter++;
            }

            if(counter == k) {
                return i+1;
            }
        }

        return -1;
    }
}
