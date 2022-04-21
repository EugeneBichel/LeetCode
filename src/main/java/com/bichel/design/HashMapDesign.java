package com.bichel.design;

import java.util.Arrays;

public class HashMapDesign {

    private class Node<T> {
        public int hash;
        public T key;
        public T value;

        public Node(T key, T value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final float LOAD_FACTOR = 0.75f;
    private static final int DEFAULT_CAPACITY = 16;
    private int capacity;
    private int size;
    private Node<Integer>[] data;

    public HashMapDesign() {
        size = 0;
        capacity = DEFAULT_CAPACITY;
        data = new Node[capacity];
    }

    public void put(int key, int value) {
        size++;

        if ((float) size / (float) capacity > LOAD_FACTOR) {
            increaseCapacity();
        }

        Node<Integer> newNode = new Node<>(key, value);
        int hash = calcHash(key);
        newNode.hash = hash;
        data[hash] = newNode;
    }

    private void increaseCapacity() {
        capacity *= 2;
        data = Arrays.copyOf(data, capacity);
    }

    private int getHash(int key) {
        int hash = key % capacity;

        if (hash >= capacity || data[hash] == null) return -1;

        while (hash < capacity && data[hash] != null && data[hash].key != key) {
            hash++;

            if (hash >= capacity || data[hash] == null) return -1;
        }

        return hash;
    }

    private int calcHash(int key) {
        while (key > capacity) {
            increaseCapacity();
        }

        int hash = key % capacity;
        return hash;
    }

    private int calcHash2(int key) {
        int hash = key % capacity;
        while (data[hash] != null && data[hash].key != key) {
            hash++;

            if ((float) hash / (float) capacity > LOAD_FACTOR) {
                increaseCapacity();
            }
        }

        return hash;
    }

    public int get(int key) {
        int hash = getHash(key);
        if (hash != -1 && data[hash] != null)
            return data[hash].value;

        return -1;
    }

    public void remove(int key) {
        int hash = getHash(key);
        if (hash >= 0 && hash < data.length)
            data[hash] = null;
    }
}
