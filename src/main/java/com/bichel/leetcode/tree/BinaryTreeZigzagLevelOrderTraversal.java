package com.bichel.leetcode.tree;

/*
Given the root of a binary tree,
return the zigzag level order traversal of its nodes' values.
(i.e., from left to right,
then right to left for the next level and alternate between).
 */

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> results = new ArrayList<>();

        // add the root element with a delimiter to kick off the BFS loop
        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.addLast(root);
        nodeQueue.addLast(null);

        LinkedList<Integer> levelList = new LinkedList<>();
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            TreeNode currNode = nodeQueue.pollFirst();

            if (currNode != null) {
                if (isOrderLeft)
                    levelList.addLast(currNode.val);
                else
                    levelList.addFirst(currNode.val);

                if (currNode.left != null)
                    nodeQueue.addLast(currNode.left);
                if (currNode.right != null)
                    nodeQueue.addLast(currNode.right);
            } else {
                // we finish the scan of one level
                results.add(levelList);
                levelList = new LinkedList<>();

                // prepare for the next level
                if (nodeQueue.size() > 0)
                    nodeQueue.addLast(null);

                isOrderLeft = !isOrderLeft;
            }
        }

        return results;
    }
}
