package com.bichel.algorithms.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumOfDigitsOfStringAfterConvertTest {
    @Test
    public void testTestCase1() {
        SumOfDigitsOfStringAfterConvert pr = new SumOfDigitsOfStringAfterConvert();

        int actual = pr.getLucky("leetcode", 2);

        assertEquals(6, actual);
    }
}
