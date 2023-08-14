package com.bichel.algorithms.problemsheap.tree.narytree;

import com.bichel.algorithms.problemsheap.graph.NtierNode;

public class MaximumDepthOfNryTree {
    private int max = 0;

    public int maxDepth(NtierNode root) {
        dfs(root, 0);
        return max;
    }

    private NtierNode dfs(NtierNode root, int level) {
        if (root == null) return null;

        level++;
        max = Math.max(max, level);

        for (int i = 0; i < root.children.size(); i++) {
            dfs(root.children.get(i), level);
        }

        return root;
    }
}
