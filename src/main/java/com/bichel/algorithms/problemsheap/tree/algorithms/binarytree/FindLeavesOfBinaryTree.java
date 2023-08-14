package com.bichel.algorithms.problemsheap.tree.algorithms.binarytree;

import com.bichel.algorithms.problemsheap.tree.datastructure.TreeNode;
import com.bichel.algorithms.unsorted.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Given the root of a binary tree,
collect a tree's nodes as if you were doing this:

Collect all the leaf nodes.
Remove all the leaf nodes.
Repeat until the tree is empty.
 */

public class FindLeavesOfBinaryTree {
    private List<Pair<Integer, Integer>> pairs;

    private int getHeight(TreeNode root) {

        if (root == null) {
            return -1;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        int currHeight = Math.max(leftHeight, rightHeight) + 1;

        // collect the pair -> (height, val)
        this.pairs.add(new Pair<>(currHeight, root.val));

        return currHeight;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        this.pairs = new ArrayList<>();

        getHeight(root);

        // sort all the (height, val) pairs
        Collections.sort(this.pairs, Comparator.comparing(p -> p.key));

        int n = this.pairs.size(), height = 0, i = 0;

        List<List<Integer>> solution = new ArrayList<>();

        while (i < n) {
            List<Integer> nums = new ArrayList<>();
            while (i < n && this.pairs.get(i).key == height) {
                nums.add(this.pairs.get(i).value);
                i++;
            }
            solution.add(nums);
            height++;
        }
        return solution;
    }

    public void findLeaves(TreeNode root, List<Integer> leaves) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }

        findLeaves(root.left, leaves);
        findLeaves(root.right, leaves);
    }
}
