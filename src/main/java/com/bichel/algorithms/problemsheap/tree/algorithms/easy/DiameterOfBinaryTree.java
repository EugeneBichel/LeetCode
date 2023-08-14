package com.bichel.algorithms.problemsheap.tree.algorithms.easy;

import com.bichel.algorithms.problemsheap.tree.datastructure.TreeNode;

public class DiameterOfBinaryTree {
    private int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;

        longestPath(root);

        return diameter;
    }

    private int longestPath(TreeNode node) {
        if (node == null)
            return 0;

        int leftPath = longestPath(node.left);
        int rightPath = longestPath(node.right);

        diameter = Math.max(diameter, leftPath + rightPath);

        return Math.max(leftPath, rightPath) + 1;
    }
}
