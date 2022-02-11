package com.bichel.leetcode.disjoint_set_union;

public class UnionFind {
    private int[] group;
    private int[] rank;

    public UnionFind(int size) {
        this.group = new int[size];
        this.rank = new int[size];

        for (int person = 0; person < size; person++) {
            this.group[person] = person;
            this.rank[person] = 0;
        }
    }

    /** Return the id of group that the person belongs to. */
    public int find(int person) {
        if (this.group[person] != person)
            this.group[person] = this.find(this.group[person]);
        return this.group[person];
    }

    /**
     * If it is necessary to merge the two groups that x, y belong to.
     * @return true: if the groups are merged.
     */
    public boolean union(int a, int b) {
        int groupA = this.find(a);
        int groupB = this.find(b);

        // The two people share the same group.
        if (groupA == groupB)
            return false;

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
