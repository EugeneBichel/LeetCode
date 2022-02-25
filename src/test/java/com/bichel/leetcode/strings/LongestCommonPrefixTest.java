package com.bichel.leetcode.strings;

import org.junit.jupiter.api.Test;

public class LongestCommonPrefixTest {
    @Test
    public void test1() {
        String[] a = {"cir","car"};
        LongestCommonPrefix pr = new LongestCommonPrefix();
        String prefix = pr.longestCommonPrefix(a);
    }
}
