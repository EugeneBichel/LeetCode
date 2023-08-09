package com.bichel.algorithms.problemsheap.graph;

/*
There is a directed graph of n nodes with each node labeled from 0 to n - 1.
The graph is represented by a 0-indexed 2D integer array graph
where graph[i] is an integer array of nodes adjacent to node i,
meaning there is an edge from node i to each node in graph[i].

A node is a terminal node if there are no outgoing edges.
A node is a safe node if every possible path starting from
that node leads to a terminal node (or another safe node).

Return an array containing all the safe nodes of the graph.
The answer should be sorted in ascending order.
 */

/*
Discussions:
To solve the problem, we must first consider when a node is safe or unsafe.
If we begin at any node and proceed along any path from that node,
we will eventually reach either a terminal node or enter a cycle
and continue to loop in it without ever reaching a terminal node.

If there is no path from the node that enters a cycle,
we will always be able to reach a terminal node. As a result,
such a node is a safe node and should be added to our answer array.

The problem is reduced to finding the nodes
that do not have any paths that lead to a cycle.
 */

/*
Algorithm
Create an integer n equal to the length of graph to get the number of nodes
in the given graph.

Create an array indegree of length n where indegree[x] stores the number of edges
entering node x.

We create an adjacency list adj in which adj[x] contains all the nodes
with an incoming edge from node x, i.e., neighbors of node x.
We create this adjacency list by iterating over graph and adding the reverse edges.
For a node i which originally has outgoing edges to nodes in graph[i],
we push i into adj[node] to add a reverse edge from node to i.

Initialize a queue of integers q and start a BFS algorithm moving from the leaf nodes
to the parent nodes.
Begin the BFS traversal by pushing all of the leaf nodes (indegree equal to 0) in the queue.
Create a boolean array safe of size n to track the safe nodes in the graph.

While the queue is not empty;
Dequeue the first node from the queue.

Mark node as safe.
For each neighbor (nodes that have an incoming edge from node) of node,
we decrement indegree[neighbor]by 1 to delete the node -> neighbor edge.
If indegree[neighbor] == 0, it means that neighbor behaves as a leaf node,
so we push neighbor in the queue.

Create an answer array safeNodes of size n.
Iterate over all the nodes from 0 to n - 1 and add all the safe nodes in safeNodes.
Return safeNodes.
 */

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] indegree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int node : graph[i]) {
                adj.get(node).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        // Push all the nodes with indegree zero in the queue.
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        boolean[] safe = new boolean[n];
        while (!q.isEmpty()) {
            int node = q.poll();
            safe[node] = true;

            for (int neighbor : adj.get(node)) {
                // Delete the edge "node -> neighbor".
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }


}
