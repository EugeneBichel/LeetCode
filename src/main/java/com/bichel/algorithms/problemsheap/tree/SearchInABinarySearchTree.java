package com.bichel.algorithms.problemsheap.tree;

/*
You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val
and return the subtree rooted with that node.
If such a node does not exist, return null
 */

public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && val != root.val)
            root = val < root.val ? root.left : root.right;

        return root;
    }
}
