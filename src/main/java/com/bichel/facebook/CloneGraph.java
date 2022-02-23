package com.bichel.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Time Complexity:
        O(N + M),
            where N is a number of nodes (vertices)
            and M is a number of edges.
Space Complexity:
        O(N),
            this space is occupied by the visited hash map and in addition to that,
            space would also be occupied by the recursion stack since we are adopting
            a recursive approach here.
            The space occupied by the recursion stack would be equal
            to O(H) where H is the height of the graph. Overall,
            the space complexity would be O(N).
 */


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

        Node cloneNode = new Node(node.val, new ArrayList<>());
        visited.put(node, cloneNode);

        for (Node neighbor: node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }
}
