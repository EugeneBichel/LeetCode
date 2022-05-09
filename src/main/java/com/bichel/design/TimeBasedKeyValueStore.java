package com.bichel.design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
Design a time-based key-value data structure
that can store multiple values for the same key
at different time stamps and retrieve the key's value at a certain timestamp.

Implement the TimeMap class:

TimeMap() Initializes the object of the data structure.
void set(String key, String value, int timestamp)
Stores the key key with the value value at the given time timestamp.
String get(String key, int timestamp) Returns a value such that
set was called previously, with timestamp_prev <= timestamp.
If there are multiple such values, it returns the value associated
with the largest timestamp_prev. If there are no values, it returns "".
 */

public class TimeBasedKeyValueStore {
    private Map<String, TreeMap<Integer, String>> data;

    public TimeBasedKeyValueStore() {
        data = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!data.containsKey(key)) {
            data.put(key, new TreeMap<>());
        }

        data.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!data.containsKey(key)) return "";

        TreeMap<Integer, String> record = data.get(key);

        Integer floorKey = record.floorKey(timestamp);

        if (floorKey == null)
            return "";

        return record.get(floorKey);
    }
}
