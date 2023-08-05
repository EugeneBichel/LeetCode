package com.bichel.algorithms.strings;

import org.junit.jupiter.api.Test;

public class IsIsomorphicTest {
    @Test
    public void test1() {
        String s = "badc";
        String t = "baba";

        IsIsomorphic pr = new IsIsomorphic();

        System.out.println(pr.isIsomorphic(s, t));
    }
}
