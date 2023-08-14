package com.bichel.algorithms.problemsheap.tree.binarysearchtree;

import com.bichel.algorithms.problemsheap.tree.TreeNode;

public class KthSmallestElementInABST {
    private int ans = 0;
    private int ind = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return ans;
    }

    private void inorder(TreeNode root, int k) {
        if(root == null) return;

        inorder(root.left, k);
        ind++;
        if(k == ind) {
            ans = root.val;
            return;
        }
        inorder(root.right, k);
    }
}
