package com.bichel.leetcode.graph.tree;

import com.bichel.leetcode.graph.TreeNode;

public class BinaryTreeLongestConsecutiveSequence {
    private int maxLen = 0;

    public int longestConsecutive(TreeNode root) {
        dfs(root, null, 0);
        return maxLen;
    }

    private void dfs(TreeNode node, TreeNode parent, int length) {
        if(node == null) return;
        length = parent != null &&
                node.val == parent.val + 1 ?
                length + 1 : 1;

        maxLen = Math.max(maxLen, length);

        dfs(node.left, node, length);
        dfs(node.right, node, length);
    }
}
