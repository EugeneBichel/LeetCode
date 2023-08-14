package com.bichel.algorithms.problemsheap.tree.traversal;

import com.bichel.algorithms.problemsheap.tree.TreeNode;

public class MorrisTraversal {
    public void morris(TreeNode root) {
        if (root == null)
            return;

        TreeNode curr, prev;

        curr = root;
        while (curr != null) {
            if (curr.left == null) {
                curr = curr.right;
            } else {
                prev = curr.left;
                while (prev.right != null && prev.right != curr)
                    prev = prev.right;

                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                }

                else {
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
    }
}
