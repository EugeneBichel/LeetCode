package com.bichel.leetcode.arrays;

import com.bichel.leetcode.arrays.contiguous_subarray.ContinuousSubarraySym;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContinuousSubarraySymTest {

    @Test
    public void testTestCase1() {
        ContinuousSubarraySym pr = new ContinuousSubarraySym();

        int[] a = {23,2,4,6,7};
        int k = 6;

        boolean res = pr.checkSubarraySum(a, k);

        assertTrue(res);
    }

    @Test
    public void testTestCase2() {
        ContinuousSubarraySym pr = new ContinuousSubarraySym();

        int[] a = {1,2};
        int k = 3;

        boolean res = pr.checkSubarraySum(a, k);

        assertTrue(res);
    }

    @Test
    public void testTestCase3() {
        ContinuousSubarraySym pr = new ContinuousSubarraySym();

        int[] a = {0,0,0};
        int k = 3;

        boolean res = pr.checkSubarraySum(a, k);

        assertTrue(res);
    }

}
