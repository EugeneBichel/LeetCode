package com.bichel.leetcode.queues;

import com.bichel.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
Given the root of a binary tree,
return the leftmost value in the last row of the tree.
 */

public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        int ans = 0;

        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {

            int size = q.size();

            for(int i=0; i<size; i++) {
                TreeNode n = q.poll();

                if(i == 0) ans = n.val;
                if(n.left != null) q.add(n.left);
                if(n.right != null) q.add(n.right);
            }
        }

        return ans;
    }
}
