package com.bichel.leetcode.tries;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private class TrieNode {
        TrieNode() {
            children = new HashMap<>();
            end = false;
        }

        public boolean end;
        public Map<Character, TrieNode> children;
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        insert(word, root);
    }

    private void insert(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {

            char newLetter = word.charAt(i);

            if(!node.children.containsKey(newLetter)) {
                node.children.put(newLetter, new TrieNode());
            }

            node = node.children.get(newLetter);
        }

        node.end = true;
    }

    private TrieNode search(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            if (node.children.containsKey(word.charAt(i))) {
                node = node.children.get(word.charAt(i));
            } else {
                return null;
            }
        }

        return node;
    }

    public boolean search(String word) {
        TrieNode node = search(word, root);
        if(node != null && node.end == true) return true;

        return false;
    }

    public boolean startsWith(String prefix) {
        return search(prefix, root) != null;
    }
}
