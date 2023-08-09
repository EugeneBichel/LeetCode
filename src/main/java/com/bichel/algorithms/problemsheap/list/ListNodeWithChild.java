package com.bichel.algorithms.problemsheap.list;

public class ListNodeWithChild {
    public int val;
    public ListNodeWithChild prev;
    public ListNodeWithChild next;
    public ListNodeWithChild child;

    public ListNodeWithChild() {
    }

    public ListNodeWithChild(int val,
                             ListNodeWithChild prev,
                             ListNodeWithChild next,
                             ListNodeWithChild child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }
}
