package com.bichel.leetcode.bits;

import org.junit.jupiter.api.Test;

public class BitManipulationsTest {
    @Test
    public void test() {
        int i = 4;

        int a = i >> 1;
        int b = i >>> 1;

        System.out.println(a); //2
        System.out.println(b); //2

        i = -4;

        a = i >> 1;
        b = i >>> 1;

        System.out.println(a); //-2
        System.out.println(b); //2147483646
    }
}
