package com.bichel.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int value) {
            val = value;
            neighbors = new ArrayList<>();
        }
        public Node(int value, ArrayList<Node> neighbors) {
            val = value;
            this.neighbors = neighbors;
        }
    }

    private HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node cloneNode = new Node(node.val, new ArrayList<Node>());
        visited.put(node, cloneNode);

        for (Node neighbor: node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }
}
