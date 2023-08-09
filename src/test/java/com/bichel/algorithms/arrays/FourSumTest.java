package com.bichel.algorithms.arrays;

import com.bichel.algorithms.problemsheap.arrays.easy.FourSum;
import org.junit.jupiter.api.Test;

public class FourSumTest {

    @Test
    public void testGetTuples() {
        //int[] a = {1,0,-1,0,-2,2};
        int target = 0;
        //int[] a = { 10, 20, 30, 40, 1, 2 };
        int[] a = {-4,-3,-2,-1,0,0,1,2,3,4};
        //target = 91;
        target = 0;

        FourSum pr = new FourSum();
        pr.findFourElements(a, target);
    }
}
