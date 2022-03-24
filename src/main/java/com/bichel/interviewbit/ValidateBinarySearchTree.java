package com.bichel.interviewbit;

import com.bichel.leetcode.tree.TreeNode;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode node, TreeNode l, TreeNode r) {
        if (node == null) return true;

        if (l != null && l.val >= node.val) return false;
        if (r != null && r.val <= node.val) return false;

        return isValid(node.left, l, node) && isValid(node.right, node, r);
    }
}
