package com.bichel.algorithms.problemsheap.tree;

/*
Given the root of a binary tree and an integer targetSum,
return true if the tree has a root-to-leaf path such
that adding up all the values along the path equals targetSum.
A leaf is a node with no children.
 */

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;

        targetSum -= root.val;

        if(targetSum == 0 && root.left == null && root.right == null)
            return true;

        return hasPathSum(root.left, targetSum) ||
                hasPathSum(root.right, targetSum);
    }
}
