package com.bichel.algorithms;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    public int val;
    public List<GraphNode> neighbors;

    public GraphNode() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public GraphNode(int value) {
        val = value;
        neighbors = new ArrayList<>();
    }

    public GraphNode(int value, List<GraphNode> neighbors) {
        val = value;
        this.neighbors = neighbors;
    }
}
