package com.bichel.algorithms.problemsheap.tree.algorithms.binarytree;

/*
Given the root of a binary tree, return the vertical order traversal
of its nodes' values. (i.e., from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.


Time Complexity: O(N) where N is the number of nodes in the tree.
Following the same analysis in the previous BFS approach,
the only difference is that this time we don't need the costy sorting operation
(i.e. O(NlogN)).

Space Complexity: O(N) where N is the number of nodes in the tree.
The analysis follows the same logic as in the previous BFS approach.
 */

import com.bichel.algorithms.problemsheap.tree.datastructure.TreeNode;
import com.bichel.algorithms.unsorted.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeVerticalOrderTraversal2 {
        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> output = new ArrayList();
            if (root == null) {
                return output;
            }

            Map<Integer, ArrayList> columnTable = new HashMap<>();
            // Pair of node and its column offset
            Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
            int column = 0;
            queue.offer(new Pair(root, column));

            int minColumn = 0, maxColumn = 0;

            while (!queue.isEmpty()) {
                Pair<TreeNode, Integer> p = queue.poll();
                root = p.key;
                column = p.value;

                if (root != null) {
                    if (!columnTable.containsKey(column)) {
                        columnTable.put(column, new ArrayList<Integer>());
                    }
                    columnTable.get(column).add(root.val);
                    minColumn = Math.min(minColumn, column);
                    maxColumn = Math.max(maxColumn, column);

                    queue.offer(new Pair<>(root.left, column - 1));
                    queue.offer(new Pair<>(root.right, column + 1));
                }
            }

            for(int i = minColumn; i < maxColumn + 1; ++i) {
                output.add(columnTable.get(i));
            }

            return output;
        }
}
