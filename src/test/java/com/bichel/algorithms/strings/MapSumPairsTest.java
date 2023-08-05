package com.bichel.algorithms.strings;

import org.junit.jupiter.api.Test;

public class MapSumPairsTest {

    @Test
    public void testTestCase1() {

        StringBuilder sb= new StringBuilder();

        MapSumPairs pr = new MapSumPairs();
        pr.insert("apple", 3);
        pr.sum("ap");
        pr.insert("app", 2);
        pr.sum("ap");
    }
}
