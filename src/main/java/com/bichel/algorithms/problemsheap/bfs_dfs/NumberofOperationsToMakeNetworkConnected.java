package com.bichel.algorithms.problemsheap.bfs_dfs;

/*
There are n computers numbered from 0 to n-1 connected
by ethernet cables connections forming a network
where connections[i] = [a, b] represents a connection
between computers a and b.
Any computer can reach any
other computer directly or indirectly through the network.

Given an initial computer network connections.
You can extract certain cables between two directly connected computers,
and place them between any pair of disconnected computers
to make them directly connected. Return the minimum number of times
you need to do this in order to make all the computers connected.
If it's not possible, return -1.
 */

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

public class NumberofOperationsToMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1; // To connect all nodes need at least n-1 edges
        }

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] c : connections) {
            graph[c[0]].add(c[1]);
            graph[c[1]].add(c[0]);
        }

        int components = 0;
        boolean[] visited = new boolean[n];
        for (int v = 0; v < n; v++) {
            components += bfs(v, graph, visited);
        }

        return components - 1; // Need (components-1) cables to connect components together
    }

    private int bfs(int src, List<Integer>[] graph, boolean[] visited) {
        if (visited[src]) return 0;
        visited[src] = true;

        Queue<Integer> q = new LinkedList<>();
        q.offer(src);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : graph[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }
        return 1;
    }
}
