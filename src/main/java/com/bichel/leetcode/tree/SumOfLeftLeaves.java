package com.bichel.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Given the root of a binary tree, return the sum of all left leaves.

A leaf is a node with no children.
A left leaf is a leaf that is the left child of another node.
 */

public class SumOfLeftLeaves {
    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int total = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode subRoot = stack.pop();
            // Check if the left node is a leaf node.
            if (isLeaf(subRoot.left)) {
                total += subRoot.left.val;
            }
            // If the right node exists, put it on the stack.
            if (subRoot.right != null) {
                stack.push(subRoot.right);
            }
            // If the left node exists, put it on the stack.
            if (subRoot.left != null) {
                stack.push(subRoot.left);
            }
        }

        return total;
    }
}
