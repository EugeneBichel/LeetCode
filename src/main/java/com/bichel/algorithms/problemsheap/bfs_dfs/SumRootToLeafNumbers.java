package com.bichel.algorithms.problemsheap.bfs_dfs;

import com.bichel.algorithms.problemsheap.tree.datastructure.TreeNode;

import java.util.List;
import java.util.ArrayList;

/*
You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.
 */

public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        int num = 0;

        preorder(root, nums, num);

        int sum = 0;
        for (Integer val : nums) sum += val;

        return sum;
    }

    private void preorder(TreeNode root, List<Integer> nums, Integer num) {
        if (root == null) {
            return;
        }

        num = num * 10 + root.val;

        if (root.left == null && root.right == null) {
            nums.add(num);
        }

        preorder(root.left, nums, num);
        preorder(root.right, nums, num);
    }
}
