package com.bichel.design;

import java.util.LinkedList;

public class BucketWithList {
    private LinkedList<Integer> container;

    public BucketWithList() {
        container = new LinkedList<>();
    }

    public void insert(Integer key) {
        int index = this.container.indexOf(key);
        if (index == -1) {
            this.container.addFirst(key);
        }
    }

    public void delete(Integer key) {
        this.container.remove(key);
    }

    public boolean exists(Integer key) {
        int index = this.container.indexOf(key);
        return (index != -1);
    }
}
