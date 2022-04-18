package com.bichel.graph_theory;
/*
You have an undirected, connected graph of n nodes labeled from 0 to n - 1.
You are given an array graph where graph[i] is a list
of all the nodes connected with node i by an edge.

Return the length of the shortest path that visits every node.
You may start and stop at any node, you may revisit nodes multiple times,
and you may reuse edges.
 */
public class ShortestPathVisitingAllNodes {
    private int[][] cache;
    private int endingMask;

    private int dp(int node, int mask, int[][] graph) {
        if (cache[node][mask] != 0) {
            return cache[node][mask];
        }
        if ((mask & (mask - 1)) == 0) {
            // Base case - mask only has a single "1", which means
            // that only one node has been visited (the current node)
            return 0;
        }

        cache[node][mask] = Integer.MAX_VALUE - 1; // Avoid infinite loop in recursion
        for (int neighbor : graph[node]) {
            if ((mask & (1 << neighbor)) != 0) {
                int alreadyVisited = dp(neighbor, mask, graph);
                int notVisited = dp(neighbor, mask ^ (1 << node), graph);
                int betterOption = Math.min(alreadyVisited, notVisited);
                cache[node][mask] = Math.min(cache[node][mask], 1 + betterOption);
            }
        }

        return cache[node][mask];
    }

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        endingMask = (1 << n) - 1;
        cache = new int[n + 1][endingMask + 1];

        int best = Integer.MAX_VALUE;
        for (int node = 0; node < n; node++) {
            best = Math.min(best, dp(node, endingMask, graph));
        }

        return best;
    }
}
