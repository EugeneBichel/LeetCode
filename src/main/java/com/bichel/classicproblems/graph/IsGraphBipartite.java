package com.bichel.classicproblems.graph;

import java.util.Arrays;
import java.util.Stack;

/*
There is an undirected graph with n nodes,
where each node is numbered between 0 and n - 1.
You are given a 2D array graph, where graph[u] is an array of nodes
that node u is adjacent to.
More formally, for each v in graph[u],
there is an undirected edge between node u and node v.
The graph has the following properties:

There are no self-edges (graph[u] does not contain u).
There are no parallel edges (graph[u] does not contain duplicate values).
If v is in graph[u], then u is in graph[v] (the graph is undirected).
The graph may not be connected, meaning there may be two nodes u and v
such that there is no path between them.

A graph is bipartite if the nodes can be partitioned into two independent
sets A and B such that every edge in the graph connects a node in set A and a node in set B.

Return true if and only if it is bipartite.
 */

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int start = 0; start < n; start++) {
            if (color[start] == -1) {
                Stack<Integer> stack = new Stack<>();
                stack.push(start);
                color[start] = 0;

                while (!stack.empty()) {
                    Integer node = stack.pop();

                    for (int nei : graph[node]) {
                        if (color[nei] == -1) {
                            stack.push(nei);
                            color[nei] = color[node] ^ 1;
                        } else if (color[nei] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
