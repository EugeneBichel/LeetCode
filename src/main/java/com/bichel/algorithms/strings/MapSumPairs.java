package com.bichel.algorithms.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

public class MapSumPairs {

    private Map<String, Integer> mapKV;
    private Map<String, Set<String>> mapPKs;

    public MapSumPairs() {
        mapKV = new HashMap<>();
        mapPKs = new HashMap<>();
    }

    public void insert(String key, int val) {
        mapKV.put(key, val);

        int keyLength = key.length();
        int ind = 0;
        do {
            String pairK = key.substring(0, keyLength - ind);
            Set<String> keys;

            if (mapPKs.containsKey(pairK)) {
                keys = mapPKs.get(pairK);
                keys.add(key);
            } else {
                keys = new HashSet<>();
                keys.add(key);
            }
            mapPKs.put(pairK, keys);

            ind++;
        } while(keyLength > ind);
    }

    public int sum(String prefix) {

        if(!mapPKs.containsKey(prefix)) return 0;

        Set<String> keys = mapPKs.get(prefix);
        int sum = 0;
        for(String key: keys) {
            sum += mapKV.get(key);
        }

        return sum;
    }
}
