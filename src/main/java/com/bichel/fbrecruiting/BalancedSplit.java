package com.bichel.fbrecruiting;

import java.util.Arrays;

public class BalancedSplit {
    boolean balancedSplitExists(int[] arr) {

        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

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

            System.out.print("a = " + a + "; b = " + b + "; sum = " + sum + "\n");
        }

        return sum == 0;
    }
}
