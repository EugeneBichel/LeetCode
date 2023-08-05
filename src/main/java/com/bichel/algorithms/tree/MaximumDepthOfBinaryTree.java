package com.bichel.algorithms.tree;

public class MaximumDepthOfBinaryTree {

    public int maxDepth1(TreeNode root) {
        if(root == null) return 0;

        int left = maxDepth1(root.left);
        int right = maxDepth1(root.right);

        return Math.max(left, right) + 1;
    }


    private int max = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return max;
    }

    private TreeNode dfs(TreeNode node, int level) {
        if(node == null) return null;

        TreeNode left = dfs(node.left, level+1);
        TreeNode right = dfs(node.right, level+1);

        if(left == null && right == null && level > max) {
            max = level;
        }

        return node;
    }
}
