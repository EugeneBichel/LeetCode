package com.bichel.algorithms;

import com.bichel.algorithms.GraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    private Map<GraphNode, GraphNode> visited = new HashMap<>();

    public GraphNode cloneGraph(GraphNode node) {
        if (node == null) {
            return null;
        }

        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        GraphNode cloneNode = new GraphNode(node.val, new ArrayList<>());
        visited.put(node, cloneNode);

        for (GraphNode neighbor: node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }
}
