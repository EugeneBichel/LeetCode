package com.bichel.algorithms.problemsheap.tree.algorithms.binarytree.lca;

import com.bichel.algorithms.problemsheap.tree.datastructure.TreeNode;

public class LowestCommonAncestor {

    private boolean hasP = false;
    private boolean hasQ = false;

    public TreeNode findLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = findLca(root, p, q);
        return hasP && hasQ ? lca : null;
    }

    private TreeNode findLca(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        TreeNode leftLca = findLca(root.left, p, q);
        TreeNode rightLca = findLca(root.right, p, q);

        if(!hasP && root.val == p.val) {
            hasP = true;
        }
        if(!hasQ && root.val == q.val) {
            hasQ = true;
        }

        if(root.val == p.val || root.val == q.val) {
            return root;
        }

        if(leftLca != null && rightLca != null) { return root; }
        if(leftLca == null && rightLca == null) { return null; }

        return leftLca != null ? leftLca : rightLca;
    }
}
