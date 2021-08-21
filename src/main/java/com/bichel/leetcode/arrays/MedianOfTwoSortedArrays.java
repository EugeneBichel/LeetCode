package com.bichel.leetcode.arrays;

public class MedianOfTwoSortedArrays {
    public double usingInsertionSort(int[] nums1, int[] nums2) {
        int[] a = new int[nums1.length+nums2.length];
        for(int i=0; i<nums1.length; i++) a[i] = nums1[i];
        for(int j=0; j<nums2.length; j++) a[nums1.length+j] = nums2[j];

        for(int i=1; i<a.length; i++) {
            for(int j=0; j<=i; j++) {
                if(a[i] < a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        if(a.length % 2 != 0) return a[a.length/2];

        double median = (double)(a[a.length/2-1]+a[a.length/2]) / 2;

        return median;
    }
}
