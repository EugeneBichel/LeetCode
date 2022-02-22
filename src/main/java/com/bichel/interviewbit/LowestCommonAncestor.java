package com.bichel.interviewbit;

import com.bichel.leetcode.tree.TreeNode;

public class LowestCommonAncestor {
    private boolean hasB = false;
    private boolean hasC = false;

    public int lca(TreeNode A, int b, int c) {
        TreeNode n = findLca(A, b, c);
        return hasB && hasC && n != null ? n.val : -1;
    }

    private TreeNode findLca(TreeNode root, int b, int c) {
        if (root == null) return root;

        TreeNode left = findLca(root.left, b, c);
        TreeNode right = findLca(root.right, b, c);

        if (!hasB && root.val == b) hasB = true;
        if (!hasC && root.val == c) hasC = true;

        if (root.val == b || root.val == c) return root;
        if (left != null && right != null) return root;
        if (left == null && right == null) return null;

        return left != null ? left : right;
    }

    public TreeNode lcaIterative(TreeNode root, TreeNode p, TreeNode q) {

        int pVal = p.val;
        int qVal = q.val;

        TreeNode node = root;

        while (node != null) {
            int parentVal = node.val;

            if (pVal > parentVal && qVal > parentVal) {
                node = node.right;
            } else if (pVal < parentVal && qVal < parentVal) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }
}
