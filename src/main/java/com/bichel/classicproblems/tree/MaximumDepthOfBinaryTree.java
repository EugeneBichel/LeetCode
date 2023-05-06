package com.bichel.classicproblems.tree;

/*
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

import com.bichel.leetcode.tree.TreeNode;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        int maxLen = 0;

        return calcMaxLen(root, maxLen);
    }

    private int calcMaxLen(TreeNode root, int maxLen) {
        if(root == null)
            return maxLen;

        maxLen++;

        return Math.max(
                Math.max(calcMaxLen(root.left, maxLen), maxLen),
                Math.max(calcMaxLen(root.right, maxLen), maxLen)
        );
    }
}
