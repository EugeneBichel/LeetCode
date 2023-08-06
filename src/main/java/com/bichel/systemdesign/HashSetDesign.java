package com.bichel.systemdesign;

public class HashSetDesign {
    private BucketWithTree[] bucketArray;
    private int keyRange;

    public HashSetDesign() {
        this.keyRange = 769;
        this.bucketArray = new BucketWithTree[this.keyRange];
        for (int i = 0; i < this.keyRange; i++)
            this.bucketArray[i] = new BucketWithTree();
    }

    protected int _hash(int key) {
        return (key % this.keyRange);
    }

    public void add(int key) {
        int bucketIndex = this._hash(key);
        this.bucketArray[bucketIndex].insert(key);
    }

    public void remove(int key) {
        int bucketIndex = this._hash(key);
        this.bucketArray[bucketIndex].delete(key);
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int bucketIndex = this._hash(key);
        return this.bucketArray[bucketIndex].exists(key);
    }
}
