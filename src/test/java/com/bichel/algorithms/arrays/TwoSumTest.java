package com.bichel.algorithms.arrays;

import com.bichel.algorithms.problemsheap.arrays.easy.TwoSum;
import org.junit.jupiter.api.Test;

public class TwoSumTest {

    @Test
    public void testGetToIndices() {
        int[] nums = {3,2,4};
        int target = 6;

        TwoSum pr = new TwoSum();
        int[] indices = pr.getIndices(nums, target);

        System.out.println(indices[0] + "; " + indices[1]);
    }
}
