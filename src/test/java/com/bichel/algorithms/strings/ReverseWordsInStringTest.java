package com.bichel.algorithms.strings;

import com.bichel.algorithms.problemsheap.strings.ReverseWordsInString;
import org.junit.jupiter.api.Test;

public class ReverseWordsInStringTest {

    @Test
    public void test1() {
        String[] s = {"t", "h", "e", " ", "s", "k", "y", " ", "i", "s", " ", "b", "l", "u", "e"};

        ReverseWordsInString pr = new ReverseWordsInString();

        String[] res = pr.reverseWords(s);

        StringBuilder sb = new StringBuilder();
        for (String ch : res) sb.append(ch);

        System.out.println(sb.toString());
    }
}
