package com.bichel.leetcode.arrays.merging;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        merge(nums1, nums2);

        for (int x : nums1) {
            System.out.print(x + " ");
        }
    }

    private static void merge(int[] nums1, int[] nums2) {

        int[] temp = new int[nums1.length];
        int i = 0, j = 0, k = 0;

        while (j < nums2.length) {
            if (nums1[i] != 0 && nums1[i] < nums2[j]) {
                temp[k] = nums1[i++];
            } else {
                temp[k] = nums2[j++];
            }

            k++;
        }

        while (k < temp.length && i < nums1.length) {
            temp[k++] = nums1[i++];
        }

        for (int ind = 0; ind < nums1.length; ind++)
            nums1[ind] = temp[ind];
    }

    private static void usingInsertionSort(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[i - m];
        }

        for (int i = 1; i < nums1.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums1[j] > nums1[i]) {
                    int temp = nums1[j];
                    nums1[j] = nums1[i];
                    nums1[i] = temp;
                }
            }
        }
    }
}
