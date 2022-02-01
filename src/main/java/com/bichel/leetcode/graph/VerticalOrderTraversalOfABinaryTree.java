package com.bichel.leetcode.graph;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

/*
Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.
 */
public class VerticalOrderTraversalOfABinaryTree {
    List<Triplet<Integer, Integer, Integer>> nodeList = new ArrayList<>();

    private void DFS(TreeNode node, Integer row, Integer column) {
        if (node == null)
            return;
        nodeList.add(new Triplet(column, row, node.val));
        // preorder DFS traversal
        this.DFS(node.left, row + 1, column - 1);
        this.DFS(node.right, row + 1, column + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> output = new ArrayList();
        if (root == null) {
            return output;
        }

        // step 1). DFS traversal
        DFS(root, 0, 0);

        // step 2). sort the list by <column, row, value>
        Collections.sort(this.nodeList, new Comparator<Triplet<Integer, Integer, Integer>>() {
            @Override
            public int compare(Triplet<Integer, Integer, Integer> t1,
                               Triplet<Integer, Integer, Integer> t2) {
                if (t1.first.equals(t2.first))
                    if (t1.second.equals(t2.second))
                        return t1.third - t2.third;
                    else
                        return t1.second - t2.second;
                else
                    return t1.first - t2.first;
            }
        });

        // step 3). extract the values, grouped by the column index.
        List<Integer> currColumn = new ArrayList();
        Integer currColumnIndex = this.nodeList.get(0).first;

        for (Triplet<Integer, Integer, Integer> triplet : this.nodeList) {
            Integer column = triplet.first, value = triplet.third;
            if (column == currColumnIndex) {
                currColumn.add(value);
            } else {
                output.add(currColumn);
                currColumnIndex = column;
                currColumn = new ArrayList();
                currColumn.add(value);
            }
        }
        output.add(currColumn);

        return output;
    }
}
