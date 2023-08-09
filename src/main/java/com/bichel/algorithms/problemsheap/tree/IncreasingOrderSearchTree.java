package com.bichel.algorithms.problemsheap.tree;

/*
Given the root of a binary search tree,
rearrange the tree in in-order so that the leftmost node in
the tree is now the root of the tree,
and every node has no left child and only one right child.
 */

import java.util.List;
import java.util.ArrayList;

public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> longestBST = new ArrayList<>();
        inorder(root, longestBST);

        TreeNode ans = new TreeNode();
        TreeNode head = ans;
        for (Integer val : longestBST) {
            ans.right = new TreeNode(val);
            ans = ans.right;
        }

        return head.right;
    }

    private void inorder(TreeNode root, List<Integer> vals) {
        if (root == null) return;
        inorder(root.left, vals);
        vals.add(root.val);
        inorder(root.right, vals);
    }
}
