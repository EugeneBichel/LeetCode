package com.bichel.algorithms.problemsheap.tree.datastructure;

import java.util.List;

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

    public TreeNode removeLeaves(TreeNode root, List<Integer> leafs) {

        if (root == null || leafs.isEmpty()) {
            return root;
        }

        if (root.left == null && root.right == null) {

            if (leafs.contains(root.val)) {
                leafs.remove(root.val);
            }

            return null;
        }

        root.left = removeLeaves(root.left, leafs);
        root.right = removeLeaves(root.right, leafs);

        return root;
    }
}
