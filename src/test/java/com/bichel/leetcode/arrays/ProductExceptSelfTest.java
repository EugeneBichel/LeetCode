package com.bichel.leetcode.arrays;

import org.junit.jupiter.api.Test;

public class ProductExceptSelfTest {
    @Test
    public void test1() {
        ProductExceptSelf program = new ProductExceptSelf();

        int[] a = {1, 2, 3, 4};
        int[] products = program.productExceptSelf(a);

        for (int i = 0; i < products.length; i++) {
            System.out.print(products[i] + " ");
        }
    }
}
