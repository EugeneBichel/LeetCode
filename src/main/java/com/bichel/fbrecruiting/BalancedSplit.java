package com.bichel.fbrecruiting;

import java.util.Arrays;

public class BalancedSplit {
    boolean balancedSplitExists(int[] arr) {
        Arrays.sort(arr);

        int sum = 0;
        int l = 0;
        int r = arr.length - 1;

        while(l <= r) {
            int a = arr[l];
            int b = arr[r];

            if(a == b && sum == 0) return false;

            if(sum + a <= 0) {
                sum += a;
                l++;
            } else {
                sum -= b;
                r--;
            }
        }

        return sum == 0;
    }
}
