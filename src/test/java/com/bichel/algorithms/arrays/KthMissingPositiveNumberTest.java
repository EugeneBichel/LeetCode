package com.bichel.algorithms.arrays;

import org.junit.jupiter.api.Test;

public class KthMissingPositiveNumberTest {
    @Test
    public void test1() {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;

        KthMissingPositiveNumber pr = new KthMissingPositiveNumber();

        int res = pr.findKth(arr, k);
    }
}
