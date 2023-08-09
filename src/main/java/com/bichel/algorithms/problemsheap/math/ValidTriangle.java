package com.bichel.algorithms.problemsheap.math;

import java.util.Arrays;

public class ValidTriangle {
    public static void main(String[] args) {
        int[] nums = {4,2,3,4};

        System.out.println(triangleNumber(nums));
    }

    private static int betterSol(int[] nums) {
        Arrays.sort(nums);
        int amount = 0;
        for(int i=0; i<nums.length-2; i++) {
            int k = i+2;
            for(int j=i+1;j<nums.length;j++) {
                while(k<nums.length && nums[i] + nums[j] > nums[k]) k++;
                if(k>j) {
                    amount = k-j-1;
                }
            }
        }

        return amount;
    }

    private static int triangleNumber(int[] nums) {
        int amount = 0;
        for(int i=0; i < nums.length-2; i++) {
            for(int j=i+1; j<nums.length - 1; j++) {
                for(int k = j+1; k<nums.length; k++) {
                    if(isValidTriangle(nums[i], nums[j], nums[k])) amount++;
                }
            }
        }

        return amount;
    }

    private static boolean isValidTriangle(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }
}
