package com.bichel.fbrecruiting.level1;

import com.bichel.algorithms.unsorted.Cafeteria;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CafeteriaTest {
    @Test
    public void test1() {
        long N = 15;
        long K = 2;
        int M = 3;
        long[] S = {11, 6, 4};
        long expectedResult = 1;

        Cafeteria cafeteria = new Cafeteria();
        long actualResult = cafeteria.getMaxAdditionalDinersCount(N, K, M, S);

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
