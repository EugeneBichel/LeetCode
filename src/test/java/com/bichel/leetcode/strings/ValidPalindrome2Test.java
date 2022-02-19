package com.bichel.leetcode.strings;

import org.junit.jupiter.api.Test;

public class ValidPalindrome2Test {
    @Test
    public void test1() {
        ValidPalindrome2 program = new ValidPalindrome2();

        String s1 = "aba";
        String s2 = "abca";
        String s3 = "abc";
        String s4 = "eccer";
        String s5= "cxcaac";

        program.validPalindrome(s5);
    }
}
