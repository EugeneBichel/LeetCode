package com.bichel.datastructure;

public class UnionFind {
    private int[] group;
    private int[] rank;

    public UnionFind(int size) {
        this.group = new int[size];
        this.rank = new int[size];

        for (int node = 0; node < size; node++) {
            this.group[node] = node;
            this.rank[node] = 0;
        }
    }

    public int find(int node) {
        if (this.group[node] != node) {
            int parent = this.find(this.group[node]);
            this.group[node] = parent;
        }

        return this.group[node];
    }

    public boolean union(int a, int b) {
        int groupA = this.find(a);
        int groupB = this.find(b);

        if (groupA == groupB) {
            return false;
        }

        // Otherwise, merge the two groups.
        // Merge the lower-rank group into the higher-rank group.
        if (this.rank[groupA] > this.rank[groupB]) {
            this.group[groupB] = groupA;
        } else if (this.rank[groupA] < this.rank[groupB]) {
            this.group[groupA] = groupB;
        } else {
            this.group[groupA] = groupB;
            this.rank[groupB] += 1;
        }

        return true;
    }
}
