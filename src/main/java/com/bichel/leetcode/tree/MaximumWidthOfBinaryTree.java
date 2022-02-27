package com.bichel.leetcode.tree;

import java.util.ArrayDeque;

/*
Time Complexity: O(N)
We visit each node once and only once. And at each visit, it takes a constant time to process.

Space Complexity: O(N)
We used a queue to maintain the nodes along with its indices,
which is the main memory consumption of the algorithm.
Due to the nature of BFS, at any given moment,
the queue holds no more than two levels of nodes.
In the worst case, a level in a full binary tree contains at most half of the total nodes,
i.e. this is also the level where the leaf nodes reside.

Hence, the overall space complexity of the algorithm is O(N).
 */

public class MaximumWidthOfBinaryTree {
/*
    private class Pair {
        public TreeNode node;
        public int
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        // queue of elements [(node, col_index)]
        Deque<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        int maxWidth = 0;

        queue.addLast(new Pair<>(root, 0));

        while (queue.size() > 0) {
            Pair<TreeNode, Integer> head = queue.getFirst();

            // iterate through the current level
            Integer currLevelSize = queue.size();
            Pair<TreeNode, Integer> elem = null;

            for (int i = 0; i < currLevelSize; ++i) {
                elem = queue.removeFirst();
                TreeNode node = elem.getKey();
                if (node.left != null)
                    queue.addLast(new Pair<>(node.left, 2 * elem.getValue()));
                if (node.right != null)
                    queue.addLast(new Pair<>(node.right, 2 * elem.getValue() + 1));
            }

            // calculate the length of the current level,
            //   by comparing the first and last col_index.
            maxWidth = Math.max(maxWidth, elem.getValue() - head.getValue() + 1);
        }

        return maxWidth;
    }
    */
}
