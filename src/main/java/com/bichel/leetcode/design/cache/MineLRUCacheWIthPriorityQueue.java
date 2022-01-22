package com.bichel.leetcode.design.cache;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MineLRUCacheWIthPriorityQueue {

    private int capacity;
    private Map<Integer, Integer> cache;
    private PriorityQueue<HeapNode> minHeap;

    private class HeapNode {
        public int key;
        public long used;
    }

    public MineLRUCacheWIthPriorityQueue(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        minHeap = new PriorityQueue<>((a, b) -> Long.compare(a.used, b.used));
    }

    public int get(int key) {
        if(cache.containsKey(key)) {
            int value = cache.get(key);

            minHeap.removeIf(node -> node.key == key);

            HeapNode item = new HeapNode();
            item.key = key;
            item.used = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
            minHeap.add(item);

            return value;
        } else
            return -1;
    }

    public void put(int key, int value) {

        if(!cache.containsKey(key) && cache.size() == this.capacity) {
            HeapNode item = minHeap.poll();
            cache.remove(item.key);
        }

        cache.put(key, value);
        minHeap.removeIf(node -> node.key == key);

        HeapNode node = new HeapNode();
        node.key = key;
        node.used = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);

        minHeap.add(node);
    }
}
