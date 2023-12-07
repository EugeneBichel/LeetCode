package com.bichel.algorithms.problemsheap.tree.algorithms.binarytree;

/*
Given the root of a binary tree,
imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom.

Example 1:
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
 */

import com.bichel.algorithms.problemsheap.tree.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeRightSide {
    public List<Integer> rightSide(TreeNode root) {
        List<Integer> items = new ArrayList<>();
        if (root == null) {
            return items;
        }

        traverse(root, items, 0);

        return items;
    }

    private void traverse(TreeNode root, List<Integer> items, int level) {
        if (level == items.size()) {
            items.add(root.val);
        }

        if (root.right != null) {
            traverse(root.right, items, level + 1);
        }
        if (root.left != null) {
            traverse(root.left, items, level + 1);
        }
    }

    public List<Integer> usingTwoDeque(TreeNode root) {
        if (root == null) return new ArrayList<>();

        ArrayDeque<TreeNode> nextLevel = new ArrayDeque<>() {{ offer(root); }};
        new ArrayDeque<>();
        Deque<TreeNode> currLevel;
        List<Integer> rightside = new ArrayList<>();

        TreeNode node = null;
        while (!nextLevel.isEmpty()) {
            // prepare for the next level
            currLevel = nextLevel.clone();
            nextLevel.clear();

            while (! currLevel.isEmpty()) {
                node = currLevel.poll();

                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null)
                    nextLevel.offer(node.left);
                if (node.right != null)
                    nextLevel.offer(node.right);
            }

            // The current level is finished.
            // Its last element is the rightmost one.
            if (currLevel.isEmpty())
                rightside.add(node.val);
        }
        return rightside;
    }
}
