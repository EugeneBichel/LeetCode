package com.bichel.algorithms.problemsheap.tree.binarysearchtree;

/*
Given the root of a binary search tree,
return a balanced binary search tree with the same node values.
If there is more than one answer, return any of them.

A binary search tree is balanced if the depth of the two subtrees
of every node never differs by more than 1
 */

import com.bichel.algorithms.problemsheap.tree.TreeNode;

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

    private int makeVine(TreeNode grand) {
        int cnt = 0;
        TreeNode n = grand.right;

        while (n != null) {
            if (n.left != null) {
                TreeNode oldN = n;
                n = n.left;
                oldN.left = n.right;
                n.right = oldN;
                grand.right = n;
            } else {
                cnt++;
                grand = n;
                n = n.right;
            }
        }

        return cnt;
    }

    private void compress(TreeNode grand, int m) {
        TreeNode n = grand.right;

        while(m-- > 0) {
            TreeNode oldN = n;
            n = n.right;
            grand.right = n;
            oldN.right = n.left;
            n.left = oldN;
            grand = n;
            n = n.right;
        }
    }
}
