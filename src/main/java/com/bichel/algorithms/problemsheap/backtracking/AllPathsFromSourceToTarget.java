package com.bichel.algorithms.problemsheap.backtracking;

/*
Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 */

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class AllPathsFromSourceToTarget {
    private int target;
    private int[][] graph;
    private List<List<Integer>> results;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        this.target = graph.length - 1;
        this.graph = graph;
        this.results = new ArrayList<>();

        LinkedList<Integer> path = new LinkedList<>();
        path.addLast(0);

        this.backtrack(0, path);

        return this.results;
    }

    private void backtrack(int currNode, LinkedList<Integer> path) {
        if (currNode == this.target) {
            // Note: one should make a deep copy of the path
            this.results.add(new ArrayList<>(path));
            return;
        }

        // explore the neighbor nodes one after another.
        for (int nextNode : this.graph[currNode]) {
            // mark the choice, before backtracking.
            path.addLast(nextNode);

            this.backtrack(nextNode, path);

            // remove the previous choice, to try the next choice
            path.removeLast();
        }
    }
}
