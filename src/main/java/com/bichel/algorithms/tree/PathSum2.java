package com.bichel.algorithms.tree;

/*
Given the root of a binary tree and an integer targetSum,
return all root-to-leaf paths where each path's sum equals targetSum.

A leaf is a node with no children.
 */

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> sets = new ArrayList<>();
        List<Integer> set = new ArrayList<>();

        preorder(root, sets, set, targetSum);

        return sets;
    }

    private void preorder(TreeNode root, List<List<Integer>> sets, List<Integer> set, int targetSum) {
        if (root == null) return;

        set.add(root.val);
        targetSum -= root.val;

        if (targetSum == 0 && root.left == null && root.right == null) {
            sets.add(new ArrayList<>(set));
        } else {
            preorder(root.left, sets, set, targetSum);
            preorder(root.right, sets, set, targetSum);
        }

        set.remove(set.size() - 1);
    }
}
