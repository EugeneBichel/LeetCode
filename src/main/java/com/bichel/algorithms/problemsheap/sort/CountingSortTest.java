package com.bichel.algorithms.problemsheap.sort;

public class CountingSortTest {
    public static void main(String[] args) {

        int[] arr = {4, 1, 8, 5, 9, 6, 0, 7, 3, 2};

        int[] sortedArr = sort(arr, 10);

        for(int item: sortedArr) {
            System.out.print(item + " ");
        }

    }

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
