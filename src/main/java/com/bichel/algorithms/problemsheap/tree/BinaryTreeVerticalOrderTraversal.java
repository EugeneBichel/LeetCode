package com.bichel.algorithms.problemsheap.tree;

/*
Given the root of a binary tree, return the vertical order traversal
of its nodes' values. (i.e., from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.
 */

import com.bichel.algorithms.unsorted.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) {
            return output;
        }

        Map<Integer, ArrayList> columnTable = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        int column = 0;
        queue.offer(new Pair<>(root, column));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            TreeNode node = p.key;
            column = p.value;

            if (node != null) {
                if (!columnTable.containsKey(column)) {
                    columnTable.put(column, new ArrayList<Integer>());
                }

                columnTable.get(column).add(node.val);

                queue.add(new Pair<>(root.left, column - 1));
                queue.add(new Pair<>(root.right, column + 1));
            }
        }

        List<Integer> sortedKeys = new ArrayList<>(columnTable.keySet());
        Collections.sort(sortedKeys);
        for (int k : sortedKeys) {
            output.add(columnTable.get(k));
        }

        return output;
    }
}
