package com.bichel.algorithms.combinations_permutations;

import com.bichel.algorithms.problemsheap.combinations_permutations_subsets.AllPossibleCombOfRElementsInArray;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class AllPossibleCombOfRElementsInArrayTest {
    @Test
    public void testTestCase1() {
        AllPossibleCombOfRElementsInArray pr = new AllPossibleCombOfRElementsInArray();
        int n = 4;

        Set<int[]> combs = pr.combinations(n);

        System.out.println("Number of combinations is " + combs.size());

        for (int[] arr : combs) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
