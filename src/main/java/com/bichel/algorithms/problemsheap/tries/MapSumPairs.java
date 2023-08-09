package com.bichel.algorithms.problemsheap.tries;

import java.util.HashMap;
import java.util.Map;

/*
Design a map that allows you to do the following:

Maps a string key to a given value.
Returns the sum of the values that have a key with a prefix equal to a given string.
Implement the MapSum class:

MapSum() Initializes the MapSum object.
void insert(String key, int val) Inserts the key-val pair into the map. If the key already existed, the original key-value pair will be overridden to the new one.
int sum(string prefix) Returns the sum of all the pairs' value whose key starts with the prefix.
 */
public class MapSumPairs {
    class TrieNode {
        Map<Character, TrieNode> children;
        int score;

        TrieNode() {
            children = new HashMap<>();
        }
    }

    Map<String, Integer> map;
    TrieNode root;

    public MapSumPairs() {
        map = new HashMap<>();
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);

        TrieNode node = root;

        for(Character ch: key.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
            node.score += delta;
        }
    }

    public int sum(String prefix) {
        TrieNode node = root;

        for(Character ch: prefix.toCharArray()) {
            node = node.children.get(ch);
            if(node == null) return 0;
        }

        return node.score;
    }
}
