package com.bichel.algorithms.graph;

/*
There are n cities. Some of them are connected, while some are not.
If city a is connected directly with city b,
and city b is connected directly with city c,
then city a is connected indirectly with city c.

A province is a group of directly or indirectly
connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1
if the ith city and the jth city are directly connected,
and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.
 */

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {
    //isConnected is adjacency matrix
    public int findCircleNum(int[][] isConnected) {
        int num = 0;
        int vertexAmount = isConnected.length;
        int[] visited = new int[vertexAmount];
        Queue<Integer> q = new LinkedList<>();

        for (int iNode = 0; iNode < vertexAmount; iNode++) {
            if (visited[iNode] != 1) {
                q.add(iNode);
                while (!q.isEmpty()) {
                    Integer vertex = q.remove();
                    visited[vertex] = 1;

                    for (int otherV = 0; otherV < vertexAmount; otherV++) {
                        if (isConnected[vertex][otherV] == 1 && visited[otherV] != 1) {
                            q.add(otherV);
                        }
                    }
                }
                num++;
            }
        }

        return num;
    }
}
