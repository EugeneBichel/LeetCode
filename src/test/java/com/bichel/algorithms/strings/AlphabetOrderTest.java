package com.bichel.algorithms.strings;

import com.bichel.algorithms.problemsheap.strings.AlphabetOrder;
import org.junit.jupiter.api.Test;

public class AlphabetOrderTest {
    @Test
    public void test1() {
        String[] words = new String[]{"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";

        AlphabetOrder program = new AlphabetOrder();

        boolean result = program.isAlienSorted(words, order);

        System.out.println(result);
    }
}
