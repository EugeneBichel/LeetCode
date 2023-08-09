package com.bichel.algorithms.problemsheap.tree;

import java.util.ArrayList;
import java.util.List;

/*
You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.
 */

public class SumRootToLeafNumbers {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int sumNumbers(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        int num = 0;

        preorder(root, nums, num);

        int sum = 0;
        for (int val : nums) sum += val;

        return sum;
    }

    private void preorder(TreeNode root, List<Integer> nums, int num) {
        if (root == null) return;

        num = num * 10 + root.val;

        if (root.left == null && root.right == null) {
            nums.add(num);
        }

        preorder(root.left, nums, num);
        preorder(root.right, nums, num);
    }
}
