package com.bichel.algorithms.problemsheap.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {
    public TreeNextNode connect(TreeNextNode root) {
        return traverse(root);
    }

    private TreeNextNode traverse(TreeNextNode node) {
        if (node == null)
            return null;
        Queue<TreeNextNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int qSize = queue.size();
            TreeNextNode prev = null;
            TreeNextNode curr = null;

            for (int i = 0; i < qSize; i++) {
                prev = curr;
                curr = queue.poll();

                if (prev != null)
                    prev.next = curr;
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
        }
        return node;
    }
}
