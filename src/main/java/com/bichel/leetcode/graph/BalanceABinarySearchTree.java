package com.bichel.leetcode.graph;

/*
Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.

A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1
 */

public class BalanceABinarySearchTree {
    public TreeNode balanceBST(TreeNode root) {
        TreeNode grand = new TreeNode(0);
        grand.right = root;
        int cnt = makeVine(grand);
        int m = (int) Math.pow(2, (int) (Math.log(cnt + 1) / Math.log(2))) - 1;
        compress(grand, cnt - m);
        for (m = m / 2; m > 0; m /= 2)
            compress(grand, m);
        return grand.right;
    }

    int makeVine(TreeNode grand) {
        int cnt = 0;
        var n = grand.right;
        while (n != null) {
            if (n.left != null) {
                var old_n = n;
                n = n.left;
                old_n.left = n.right;
                n.right = old_n;
                grand.right = n;
            } else {
                ++cnt;
                grand = n;
                n = n.right;
            }
        }
        return cnt;
    }

    void compress(TreeNode grand, int m) {
        var n = grand.right;
        while (m-- > 0) {
            var old_n = n;
            n = n.right;
            grand.right = n;
            old_n.right = n.left;
            n.left = old_n;
            grand = n;
            n = n.right;
        }
    }
}
