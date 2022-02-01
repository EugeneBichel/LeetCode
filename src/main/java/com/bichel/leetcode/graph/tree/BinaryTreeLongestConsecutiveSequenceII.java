package com.bichel.leetcode.graph.tree;

import com.bichel.leetcode.graph.TreeNode;

public class BinaryTreeLongestConsecutiveSequenceII {
    private int maxLen = 0;

    public int longestConsecutive(TreeNode root) {
        traverse(root);
        return maxLen;
    }

    private int[] traverse(TreeNode node) {
        if(node == null) return new int[] {0,0};

        int inc = 1;
        int dcr = 1;

        if(node.left != null) {
            int[] left = traverse(node.left);
            if(node.val == node.left.val + 1) dcr = Math.max(dcr,left[1] + 1);
            else if(node.val + 1 == node.left.val) inc = Math.max(inc, left[0] + 1);
        }

        if(node.right != null) {
            int[] right = traverse(node.right);
            if(node.val == node.right.val + 1) dcr = Math.max(right[1] + 1, dcr);
            else if(node.val + 1 == node.right.val) inc = Math.max(inc, right[0] + 1);
        }

        maxLen = Math.max(maxLen, dcr+inc - 1);

        return new int[]{inc, dcr};
    }
}
