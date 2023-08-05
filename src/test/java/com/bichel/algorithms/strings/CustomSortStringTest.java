package com.bichel.algorithms.strings;

import org.junit.jupiter.api.Test;

public class CustomSortStringTest {
    @Test
    public void test1() {
        String order = "cba";
        String str = "abcd";

        order = "kqep";
        str = "pekeq";

        order = "exv";
        str = "xwvee";

        CustomSortString pr = new CustomSortString();

        String sortedStr = pr.customSortString(order, str);
        System.out.println(sortedStr);
    }
}
