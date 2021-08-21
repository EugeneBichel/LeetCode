package com.bichel.leetcode.arrays;

import java.util.Random;

public class ArrayShuffle {
    private int[] source;

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return source;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] a = source.clone();
        Random random = new Random();

        for(int i=a.length-1; i>=0; i--) {
            int ind = Math.abs(random.nextInt()) % a.length;

            int temp = a[i];
            a[i] = a[ind];
            a[ind] = temp;
        }

        return a;
    }
}
