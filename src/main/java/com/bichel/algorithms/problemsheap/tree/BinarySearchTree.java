package com.bichel.algorithms.problemsheap.tree;

public class BinarySearchTree {

    public TreeNode insertNode(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }

        boolean inserted = false;
        while (!inserted) {
            if (value < root.val) {
                if (root.left != null) {
                    root = root.left;
                } else {
                    inserted = true;
                    root.left = new TreeNode(value);
                }
            } else if (value >= root.val) {
                if (root.right != null) {
                    root = root.right;
                } else {
                    inserted = true;
                    root.right = new TreeNode(value);
                }
            }
        }

        return root;
    }
}
