package com.bichel.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/*
Implement the MapSum class:

MapSum() Initializes the MapSum object.
void insert(String key, int val) Inserts the key-val pair into the map. If the key already existed, the original key-value pair will be overridden to the new one.
int sum(string prefix) Returns the sum of all the pairs' value whose key starts with the prefix.


Example 1:

Input
["MapSum", "insert", "sum", "insert", "sum"]
[[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
Output
[null, null, 3, null, 5]

Explanation
MapSum mapSum = new MapSum();
mapSum.insert("apple", 3);
mapSum.sum("ap");           // return 3 (apple = 3)
mapSum.insert("app", 2);
mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 */

public class MapSumPairsUsingTrie {
    HashMap<String, Integer> map;
    TrieNode root;

    public MapSumPairsUsingTrie() {
        map = new HashMap();
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode cur = root;
        cur.score += delta;
        for (char c : key.toCharArray()) {
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
            cur.score += delta;
        }
    }

    public int sum(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            cur = cur.children.get(c);
            if (cur == null) return 0;
        }
        return cur.score;
    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap();
    int score;
}
