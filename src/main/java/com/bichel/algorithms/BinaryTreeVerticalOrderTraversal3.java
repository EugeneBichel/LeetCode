package com.bichel.algorithms;

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

import com.bichel.algorithms.Pair;
import com.bichel.algorithms.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeVerticalOrderTraversal3 {
    private Map<Integer, ArrayList<Pair<Integer, Integer>>> columnTable = new HashMap<>();
    int minColumn = 0, maxColumn = 0;

    private void dfs(TreeNode node, Integer row, Integer column) {
        if (node == null)
            return;

        if (!columnTable.containsKey(column)) {
            this.columnTable.put(column, new ArrayList<>());
        }

        this.columnTable.get(column).add(new Pair<>(row, node.val));
        this.minColumn = Math.min(minColumn, column);
        this.maxColumn = Math.max(maxColumn, column);

        // preorder DFS traversal
        dfs(node.left, row + 1, column - 1);
        dfs(node.right, row + 1, column + 1);
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList();
        if (root == null) {
            return output;
        }

        dfs(root, 0, 0);

        // Retrieve the resuts, by ordering by column and sorting by row
        for (int i = minColumn; i < maxColumn + 1; ++i) {

            Collections.sort(columnTable.get(i), (p1, p2) -> p1.key - p2.key);

            List<Integer> sortedColumn = new ArrayList<>();
            for (Pair<Integer, Integer> p : columnTable.get(i)) {
                sortedColumn.add(p.value);
            }
            output.add(sortedColumn);
        }

        return output;
    }
}
