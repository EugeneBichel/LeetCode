package com.bichel.algorithms.unsorted;

import java.util.ArrayList;
import java.util.List;

public class NaryTreeNode {
    public int val;
    public List<NaryTreeNode> children;

    public NaryTreeNode() {
        val = 0;
        children = new ArrayList<>();
    }

    public NaryTreeNode(int value) {
        val = value;
        children = new ArrayList<>();
    }

    public NaryTreeNode(int value, List<NaryTreeNode> children) {
        val = value;
        this.children = children;
    }
}
