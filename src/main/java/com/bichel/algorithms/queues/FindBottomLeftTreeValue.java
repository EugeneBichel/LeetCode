package com.bichel.algorithms.queues;

import com.bichel.algorithms.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
Given the root of a binary tree,
return the leftmost value in the last row of the tree.
 */

public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        int ans = 0;

        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                //left most node
                if (i == 0)
                    ans = node.val;

                if (node.left != null)
                    q.add(node.left);

                if (node.right != null)
                    q.add(node.right);
            }
        }

        return ans;
    }
}
