package com.bichel.design;

import com.bichel.design.BucketWithList;

public class HashSetDesignSimple {
    private BucketWithList[] bucketArray;
    private int keyRange;

    /**
     * Initialize your data structure here.
     */
    public HashSetDesignSimple() {
        this.keyRange = 769;
        this.bucketArray = new BucketWithList[this.keyRange];
        for (int i = 0; i < this.keyRange; i++)
            this.bucketArray[i] = new BucketWithList();
    }

    protected int hash(int key) {
        return (key % this.keyRange);
    }

    public void add(int key) {
        int bucketIndex = this.hash(key);
        this.bucketArray[bucketIndex].insert(key);
    }

    public void remove(int key) {
        int bucketIndex = this.hash(key);
        this.bucketArray[bucketIndex].delete(key);
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int bucketIndex = this.hash(key);
        return this.bucketArray[bucketIndex].exists(key);
    }
}
