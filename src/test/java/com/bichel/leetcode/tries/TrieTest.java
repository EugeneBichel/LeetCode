package com.bichel.leetcode.tries;

import org.junit.jupiter.api.Test;

public class TrieTest {
    @Test
    public void testTestCase1() {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");
        trie.search("app");
        trie.startsWith("app");
        trie.insert("app");
        trie.search("app");
    }
}
