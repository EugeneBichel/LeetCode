package com.bichel.algorithms.problemsheap.graph;

import java.util.LinkedList;

/**
 * Adjacency List: when the size of graph is not big
 * Adjacency Array: for a long list of nodes
 */
public class DFS {
    public static void main(String[] args) {

        LinkedList<Integer>[] adjList = new LinkedList[5];

        LinkedList<Integer> vertex0 = new LinkedList<>();
        vertex0.add(1);
        vertex0.add(2);

        LinkedList<Integer> vertex1 = new LinkedList<>();
        vertex1.add(0);
        vertex1.add(1);
        vertex1.add(3);
        vertex1.add(4);

        LinkedList<Integer> vertex2 = new LinkedList<>();
        vertex2.add(0);
        vertex2.add(1);
        vertex2.add(2);

        LinkedList<Integer> vertex3 = new LinkedList<>();
        vertex3.add(1);

        LinkedList<Integer> vertex4 = new LinkedList<>();
        vertex4.add(1);

        adjList[0] = vertex0;
        adjList[1] = vertex1;
        adjList[2] = vertex2;
        adjList[3] = vertex3;
        adjList[4] = vertex4;

        isReachable(adjList, 1, 2);
    }

    private static boolean isReachable(LinkedList<Integer>[] adjList, int a, int b) {

        NodeStatus[] nodes = new NodeStatus[adjList.length];
        for(int i = 0; i < nodes.length; i++) {
            nodes[i] = NodeStatus.White;
        }

        nodes[a] = NodeStatus.Black;

        explore(adjList, nodes, a);

        if(nodes[b] == NodeStatus.Black) {
            return true;
        }

        return false;
    }

    private static void explore(LinkedList<Integer>[] adjList, NodeStatus[] nodes, Integer currNode) {

        LinkedList<Integer> list = adjList[currNode];

        for(Integer item : list) {
            if(nodes[item] == NodeStatus.White) {
                nodes[item] = NodeStatus.Gray;

                explore(adjList, nodes, item);
            }

            nodes[item] = NodeStatus.Black;
        }
    }

    enum NodeStatus {
        White, Gray, Black
    }
}
