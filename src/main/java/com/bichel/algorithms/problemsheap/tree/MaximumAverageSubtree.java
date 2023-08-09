package com.bichel.algorithms.problemsheap.tree;

/*
Given the root of a binary tree, return the maximum average value of a subtree of that tree.
Answers within 10-5 of the actual answer will be accepted.

A subtree of a tree is any node of that tree plus all its descendants.

The average value of a tree is the sum of its values, divided by the number of nodes.
 */

public class MaximumAverageSubtree {
    double max = Integer.MIN_VALUE;

    public double maximumAverageSubtree(TreeNode root) {
        if (root == null) return max;
        helper(root);
        return max;
    }

    private double[] helper(TreeNode root) {
        if (root == null) return new double[]{0, 0};

        double curTotal = root.val;
        double count = 1;

        double[] cur;

        cur = helper(root.left);
        curTotal += cur[0];
        count += cur[1];
        cur = helper(root.right);
        curTotal += cur[0];
        count += cur[1];

        double avg = curTotal / count;
        if (avg > max) {
            max = avg;
        }

        return new double[]{curTotal, count};
    }
}
