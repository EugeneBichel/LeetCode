package com.bichel.leetcode.graph;

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
