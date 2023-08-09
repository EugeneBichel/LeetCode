package com.bichel.algorithms.problemsheap.tree;

/*
Given the roots of two binary search trees, root1 and root2,
return true if and only if there is a node in the first tree and a node
in the second tree whose values sum up to a given integer target.
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class TwoSumBSTs {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {

        Set<Integer> valuesTree1 = new HashSet<>();
        Deque<TreeNode> q = new ArrayDeque<>();

        q.push(root1);
        while (!q.isEmpty()) {
            TreeNode node = q.pop();
            valuesTree1.add(node.val);

            if (node.left != null) q.push(node.left);
            if (node.right != null) q.push(node.right);
        }

        q.push(root2);
        while (!q.isEmpty()) {
            TreeNode node = q.pop();
            if (valuesTree1.contains(target - node.val))
                return true;

            if (node.left != null) q.push(node.left);
            if (node.right != null) q.push(node.right);
        }

        return false;
    }
}
