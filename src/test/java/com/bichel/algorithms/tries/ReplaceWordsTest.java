package com.bichel.algorithms.tries;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReplaceWordsTest {
    @Test
    public void testTestCase1() {
        ReplaceWords pr = new ReplaceWords();

        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");

        String sentence = "the cattle was rattled by the battery";
        String expected = "the cat was rat by the bat";

        String actual = pr.replaceWords(dict, sentence);

        assertEquals(expected, actual);
    }
}
