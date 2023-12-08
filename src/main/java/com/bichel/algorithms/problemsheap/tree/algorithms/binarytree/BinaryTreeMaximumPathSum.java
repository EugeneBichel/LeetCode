package com.bichel.algorithms.problemsheap.tree.algorithms.binarytree;

/*
A path in a binary tree is a sequence of nodes
where each pair of adjacent nodes in the sequence has an edge connecting them.
A node can only appear in the sequence at most once.
Note that the path does not need to pass through the root.
The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.


Time complexity: O(N), where N is number of nodes,
since we visit each node not more than 2 times.
Space complexity: O(H), where H is a tree height, to keep the recursion stack.
In the average case of balanced tree, the tree height H = logN,
in the worst case of skewed tree, H = N.
 */

import com.bichel.algorithms.problemsheap.tree.datastructure.TreeNode;

public class BinaryTreeMaximumPathSum {
    int max_sum = Integer.MIN_VALUE;

    private int max_gain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // max sum on the left and right sub-trees of node
        int left_gain = Math.max(max_gain(node.left), 0);
        int right_gain = Math.max(max_gain(node.right), 0);

        // the price to start a new path where `node` is a highest node
        int price_newpath = node.val + left_gain + right_gain;

        // update max_sum if it's better to start a new path
        max_sum = Math.max(max_sum, price_newpath);

        // for recursion :
        // return the max gain if continue the same path
        return node.val + Math.max(left_gain, right_gain);
    }

    public int maxPathSum(TreeNode root) {
        max_gain(root);
        return max_sum;
    }
}
