package com.bichel.other.Graphs;

import java.util.LinkedList;

public class BFS {
    public static void main(String[] args) {

    }

    private static boolean searchBFS(LinkedList<Integer>[] adjList, int a) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.push(a);

        while (!queue.isEmpty()) {

            int node = queue.pop();
            LinkedList<Integer> adjs = adjList[node];

            for (int i = 0; i < adjs.size(); i++) {

                if (adjs.get(i) == a) {
                    return true;
                }

                queue.push(adjs.get(i));
            }
        }
        return false;
    }
}
