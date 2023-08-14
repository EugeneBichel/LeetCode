package com.bichel.algorithms.problemsheap.sort;

/*
Sometimes, tree related problems can be solved using divide-and-conquer algorithms.

 */

import com.bichel.algorithms.problemsheap.tree.datastructure.TreeNode;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode p, TreeNode l, TreeNode r) {
        if(p == null) return true;

        if(l != null && p.val <= l.val) return false;
        if(r != null && p.val >= r.val) return false;

        return isValid(p.left, l, p) && isValid(p.right, p, r);
    }
}
