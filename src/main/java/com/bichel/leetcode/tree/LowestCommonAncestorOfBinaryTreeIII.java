package com.bichel.leetcode.tree;

import com.bichel.leetcode.graph.ParentNode;

public class LowestCommonAncestorOfBinaryTreeIII {
    private boolean hasP, hasQ;

    public ParentNode lowestCommonAncestor(ParentNode p, ParentNode q) {
        if(p == null || q == null) return null;
        if(p == q) return p.parent;

        ParentNode root = p;

        while(root.parent != null) root = root.parent;

        ParentNode lca = findLca(root, p, q);

        return hasP && hasQ ? lca : null;
    }

    private ParentNode findLca(ParentNode root, ParentNode p, ParentNode q) {
        if(root == null) return null;

        ParentNode leftLca = findLca(root.left, p, q);
        ParentNode rightLca = findLca(root.right, p, q);

        if(!hasP && root.val == p.val) {
            hasP = true;
        }
        if(!hasQ && root.val == p.val) {
            hasQ = true;
        }

        if(root.val == p.val || root.val == q.val) return root;

        if(leftLca != null && rightLca != null) return root;
        if(leftLca == null && rightLca == null) return null;

        return leftLca != null ? leftLca : rightLca;
    }
}
