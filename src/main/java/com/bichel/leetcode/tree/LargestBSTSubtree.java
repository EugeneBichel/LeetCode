package com.bichel.leetcode.tree;

/*
Given the root of a binary tree, find the largest subtree,
which is also a Binary Search Tree (BST),
where the largest means subtree has the largest number of nodes.

A Binary Search Tree (BST) is a tree in which all the nodes follow
the below-mentioned properties:
The left subtree values are less than the value of their parent (root) node's value.
The right subtree values are greater than the value of their parent (root) node's value.
Note: A subtree must include all of its descendants.
 */

public class LargestBSTSubtree {
    // Track previous node while doing inorder traversal.
    private TreeNode previous;

    // Function to check if given tree is a valid Binary Search Tree or not.
    private boolean isValidBST(TreeNode root) {
        // An empty tree is a valid Binary Search Tree.
        if (root == null) {
            return true;
        }

        // If left subtree is not a valid BST return false.
        if (!isValidBST(root.left)) {
            return false;
        }

        // If current node's value is not greater than the previous
        // node's value in the in-order traversal return false.
        if (previous != null && previous.val >= root.val) {
            return false;
        }

        // Update previous node to current node.
        previous = root;

        // If right subtree is not a valid BST return false.
        return isValidBST(root.right);
    }

    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Add nodes in left and right subtree.
        // Add 1 and return total size.
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Set previous node to NULL initially.
        previous = null;

        // If current subtree is a validBST, its children will have smaller size BST.
        if (isValidBST(root)) {
            return countNodes(root);
        }

        // Find BST in left and right subtrees of current nodes.
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
}
