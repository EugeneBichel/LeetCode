package com.bichel.algorithms.unsorted;

import com.bichel.algorithms.problemsheap.LinkedList;

import java.util.Stack;

public class TopologicalSort {
    /*
    Topological Sort is a way to order a directed acyclic graph.
    A directed graph has edges that are incoming or outgoing,
    meaning that they have a specific direction.
    An acyclic graph has no cycles, i.e.,
    a node is not reachable from its ancestors.
    A topological sort takes a graph and finds the order of
    its nodes so it always starts from a node that has no
    incoming edges and then traverses the adjacent nodes.
    Note that the current node is before its adjacent.
     */


}

class TopologicalSortClass {

    static class Graph {
        int numVertices;
        LinkedList[] tempList;

        Graph(int numVertices) {
            this.numVertices = numVertices;
            tempList = new LinkedList[numVertices];
            for (int i = 0; i < numVertices ; i++) {
                tempList[i] = new LinkedList();
            }
        }

        // Method to add an edge between 2 nodes in the Graph
        // fromNode 2 toNode 4 ==> 2 -> 4
        public void addEgde(int fromNode, int toNode) {
            //tempList[fromNode].addFirst(toNode);
        }

        public void topologicalSorting() {
            boolean[] visited = new boolean[numVertices];
            Stack<Integer> ts = new Stack<>();

            //visit from each node if not already visited
            for (int i = 0; i < numVertices; i++) {
                if (!visited[i]) {
                    topologicalSortRecursive(i, visited, ts);
                }
            }
            System.out.println("Topological Sort: ");
            int size = ts.size();
            for (int i = 0; i < size; i++) {
                System.out.print(ts.pop() + " ");
            }
        }

        public void topologicalSortRecursive(int start, boolean[] visited, Stack<Integer> ts) {
            visited[start] = true;
           /* for (int i = 0; i < tempList[start].size(); i++) {
                int vertex = tempList[start].get(i);
                if (!visited[vertex])
                    topologicalSortRecursive(vertex, visited, ts);
            }*/
            ts.push(start);
        }

    }

    public static void main( String args[] ) {
        System.out.println( "Path after Topological Sorting: " );

        int nVertices = 5;

        Graph g = new Graph(nVertices);

        g.addEgde(0, 1);
        g.addEgde(0, 4);
        g.addEgde(1, 2);
        g.addEgde(1, 3);
        g.addEgde(2, 3);
        g.addEgde(2, 4);

        // Topological function called here
        g.topologicalSorting();

    }

}
