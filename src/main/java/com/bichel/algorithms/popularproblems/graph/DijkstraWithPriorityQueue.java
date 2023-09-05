package com.bichel.algorithms.popularproblems.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class DijkstraWithPriorityQueue {
    // Member variables of this class
    private int dist[];
    private Set<Integer> settled;
    private PriorityQueue<Node2> pq;
    // Number of vertices
    private int V;
    List<List<Node2> > adj;

    public DijkstraWithPriorityQueue(int V) {
        // This keyword refers to current object itself
        this.V = V;
        dist = new int[V];
        settled = new HashSet<>();
        pq = new PriorityQueue<Node2>(V, new NodeComparator());
    }

    public void dijkstra(List<List<Node2>> adj, int src) {
        this.adj = adj;

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // Add source node to the priority queue
        pq.add(new Node2(src, 0));

        // Distance to the source is 0
        dist[src] = 0;

        while (settled.size() != V) {

            // Terminating condition check when
            // the priority queue is empty, return
            if (pq.isEmpty()) {
                return;
            }

            // Removing the minimum distance node
            // from the priority queue
            int u = pq.remove().node;

            // Adding the node whose distance is
            // finalized
            if (settled.contains(u))

                // Continue keyword skips execution for
                // following check
                continue;

            // We don't have to call e_Neighbors(u)
            // if u is already present in the settled set.
            settled.add(u);

            e_Neighbours(u);
        }
    }

    private void e_Neighbours(int u) {

        int edgeDistance = -1;
        int newDistance = -1;

        // All the neighbors of v
        for (int i = 0; i < adj.get(u).size(); i++) {
            Node2 v = adj.get(u).get(i);

            // If current node hasn't already been processed
            if (!settled.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;

                // If new distance is cheaper in cost
                if (newDistance < dist[v.node])
                    dist[v.node] = newDistance;

                // Add the current node to the queue
                pq.add(new Node2(v.node, dist[v.node]));
            }
        }
    }

    public static void main(String arg[]) {
        int V = 5;
        int source = 0;

        // Adjacency list representation of the
        // connected edges by declaring List class object
        // Declaring object of type List<Node2>
        List<List<Node2>> adj = new ArrayList<>();

        // Initialize list for every node
        for (int i = 0; i < V; i++) {
            List<Node2> item = new ArrayList<>();
            adj.add(item);
        }

        // Inputs for the GFG(dpq) graph
        adj.get(0).add(new Node2(1, 9));
        adj.get(0).add(new Node2(2, 6));
        adj.get(0).add(new Node2(3, 5));
        adj.get(0).add(new Node2(4, 3));

        adj.get(2).add(new Node2(1, 2));
        adj.get(2).add(new Node2(3, 4));

        // Calculating the single source shortest path
        DijkstraWithPriorityQueue dpq = new DijkstraWithPriorityQueue(V);
        dpq.dijkstra(adj, source);

        // Printing the shortest path to all the nodes
        // from the source node
        System.out.println("The shorted path from node :");

        for (int i = 0; i < dpq.dist.length; i++)
            System.out.println(source + " to " + i + " is "
                    + dpq.dist[i]);
    }
}

class Node2 {
    public int node;
    public int cost;

    public Node2() {
    }

    public Node2(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}
class NodeComparator implements Comparator<Node2> {

    @Override
    public int compare(Node2 o1, Node2 o2) {
        if (o1.cost < o2.cost)
            return -1;

        if (o1.cost > o2.cost)
            return 1;

        return 0;
    }
}
