package com.bichel.leetcode.tree;

import java.util.List;

public class FindLeavesOfBinaryTree {

    public TreeNode insertNode(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }

        boolean inserted = false;
        while (inserted == false) {
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

    public void findLeaves(TreeNode root, List<Integer> leaves) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }

        findLeaves(root.left, leaves);
        findLeaves(root.right, leaves);
    }

    public TreeNode removeLeaves(TreeNode root, List<Integer> leafs) {

        if (root == null || leafs.isEmpty()) {
            return root;
        }

        if (root.left == null && root.right == null) {

            if (leafs.contains(root.val)) {
                int index = leafs.indexOf(root.val);
                leafs.remove(index);
            }

            return null;
        }

        root.left = removeLeaves(root.left, leafs);
        root.right = removeLeaves(root.right, leafs);

        return root;
    }
}
