package com.bichel.leetcode.tree;

/*
Given the root of a binary search tree and a target value,
return the value in the BST that is closest to the target.
 */

public class ClosestBinarySearchTreeValue {
    private int val = 0;
    private double diff = Double.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        findVal(root, target);
        return val;
    }

    private void findVal(TreeNode root, double target) {
        if(root == null) return;

        closestValue(root.left, target);
        closestValue(root.right, target);

        if(Math.abs(target-root.val) < diff) {
            diff = Math.abs(target-root.val);
            val = root.val;
        }
    }
}
