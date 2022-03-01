package com.bichel.leetcode.bits;

import com.bichel.leetcode.bit.SumOfTwoIntegers;
import org.junit.jupiter.api.Test;

public class SumOfTwoIntegersTest {
    @Test
    public void test1() {
        String a = "11";
        String b = "1";

        int val1 = Integer.parseInt(a, 2);
        int val2 = Integer.parseInt(b, 2);

        SumOfTwoIntegers pr = new SumOfTwoIntegers();
        Integer res = pr.getSum(val1, val2);

        System.out.println(Integer.toBinaryString(res));
    }
}
