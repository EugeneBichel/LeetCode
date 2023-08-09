package com.bichel.algorithms.problemsheap.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Given the root of a binary tree, return the sum of values of its deepest leaves.
 */

public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        ArrayDeque<TreeNode> nextLevel = new ArrayDeque<>();
        Deque<TreeNode> currLevel = new ArrayDeque<>();
        nextLevel.offer(root);

        while (!nextLevel.isEmpty()) {
            currLevel = nextLevel.clone();
            nextLevel.clear();

            for (TreeNode node : currLevel) {
                if (node.left != null) {
                    nextLevel.offer(node.left);
                }
                if (node.right != null) {
                    nextLevel.offer(node.right);
                }
            }
        }

        int deepestSum = 0;
        for (TreeNode node : currLevel) {
            deepestSum += node.val;
        }
        return deepestSum;
    }
}
