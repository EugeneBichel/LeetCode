package com.bichel.other.collections.DisjointSets;

public class DisjointSet {

    private int[] parent;
    public int[] rank;

    public DisjointSet(int n) {
        parent = new int[n+1];
        rank = new int[n+1];
    }

    public void makeSet(int i) {
        parent[i] = i;
        rank[i] = 0;
    }

    public int find(int i) {
        while(parent[i] != i) {
            i = parent[i];
        }

        return i;
    }

    public int findWithPathCompression(int i) {
        if(parent[i] != i) {
            parent[i] = findWithPathCompression(parent[i]);
        }

        return parent[i];
    }

    public void union(int i, int j) {
        int i_id = find(i);
        int j_id = find(j);

        if(i_id == j_id) {
            return;
        }

        if(rank[i_id] > rank[j_id]) {
            parent[j_id] = i_id;
        } else {
            parent[i_id] = j_id;

            if(rank[i_id] == rank[j_id]) {
                rank[i_id] += 1;
            }
        }
    }

    public void unionWithPathCompression(int i, int j) {
        int i_id = findWithPathCompression(i);
        int j_id = findWithPathCompression(j);

        if(i_id == j_id) {
            return;
        }

        if(rank[i_id] > rank[j_id]) {
            parent[j_id] = i_id;
        } else {
            parent[i_id] = j_id;

            if(rank[i_id] == rank[j_id]) {
                rank[i_id] += 1;
            }
        }
    }
}
