package com.bichel.algorithms.problemsheap.graph;

import java.util.List;

public class NtierNode {
    public int val;
    public List<NtierNode> children;

    public NtierNode() {}

    public NtierNode(int val) {
        this.val = val;
    }

    public NtierNode(int val, List<NtierNode> children) {
        this.val = val;
        this.children = children;
    }
}
