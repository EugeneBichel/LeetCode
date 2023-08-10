package com.bichel.algorithms.unsorted;

import java.util.HashSet;

public class sumOfPair {

    public static void main(String[] args) {

        int[] arr = {2, 1, 4, 3, 7};
        int pairSum = 8;

        boolean hasPair = findPairWithSum(arr, pairSum);
    }


    private static boolean findPairWithSum(final int[] arr, final int pairSum) {

        HashSet<Integer> complements = new HashSet<>();

        for(Integer item: arr) {
            if(complements.contains(item)) {
                return true;
            }

            complements.add(pairSum - item);
        }

        return false;
    }
}
