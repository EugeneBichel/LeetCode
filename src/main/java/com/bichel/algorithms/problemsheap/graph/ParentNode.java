package com.bichel.algorithms.problemsheap.graph;

public class ParentNode {
    public int val;
    public ParentNode left;
    public ParentNode right;
    public ParentNode parent;

    ParentNode() {
    }

    ParentNode(int val) {
        this.val = val;
    }

    ParentNode(int val, ParentNode left, ParentNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
