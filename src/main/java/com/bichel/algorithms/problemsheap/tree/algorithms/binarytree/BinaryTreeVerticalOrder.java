package com.bichel.algorithms.problemsheap.tree.algorithms.binarytree;

import com.bichel.algorithms.problemsheap.tree.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.List;

public class BinaryTreeVerticalOrder {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Map<Integer, List<Integer>> columnMap = new HashMap<>();
        int minColumn = 0, maxColumn = 0;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> columnQueue = new LinkedList<>();

        nodeQueue.offer(root);
        columnQueue.offer(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode current = nodeQueue.poll();
            int column = columnQueue.poll();

            if (!columnMap.containsKey(column)) {
                columnMap.put(column, new ArrayList<>());
            }

            columnMap.get(column).add(current.val);

            minColumn = Math.min(minColumn, column);
            maxColumn = Math.max(maxColumn, column);

            if (current.left != null) {
                nodeQueue.offer(current.left);
                columnQueue.offer(column - 1);
            }

            if (current.right != null) {
                nodeQueue.offer(current.right);
                columnQueue.offer(column + 1);
            }
        }

        for (int i = minColumn; i <= maxColumn; i++) {
            result.add(columnMap.get(i));
        }

        return result;
    }
}
