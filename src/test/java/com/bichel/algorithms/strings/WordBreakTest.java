package com.bichel.algorithms.strings;

import org.junit.jupiter.api.Test;

import java.util.List;

public class WordBreakTest {

    @Test
    public void test1() {
        WordBreak pr = new WordBreak();

        String s = "leetcode";
        List<String> dict = List.of("leet", "code");

        s = "applepenapple";
        dict = List.of("apple", "pen");

        s = "catsandog";
        dict = List.of("cats", "dog", "sand", "and", "cat");

        s = "a";
        dict = List.of("b");

        boolean res = pr.wordBreak(s, dict);
    }
}
