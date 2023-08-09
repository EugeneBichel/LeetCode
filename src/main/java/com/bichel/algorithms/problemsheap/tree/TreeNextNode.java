package com.bichel.algorithms.problemsheap.tree;

public class TreeNextNode {
    public int val;
    public TreeNextNode left;
    public TreeNextNode right;
    public TreeNextNode next;

    TreeNextNode() {
    }

    public TreeNextNode(int val) {
        this.val = val;
    }

    TreeNextNode(int val, TreeNextNode left, TreeNextNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNextNode(int val, TreeNextNode left, TreeNextNode right, TreeNextNode next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
