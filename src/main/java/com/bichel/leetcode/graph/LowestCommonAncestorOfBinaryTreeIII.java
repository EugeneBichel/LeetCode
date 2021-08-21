package com.bichel.leetcode.graph;

public class LowestCommonAncestorOfBinaryTreeIII {
    public static void main(String[] args) {

    }

    private boolean hasP, hasQ;

    public ParentNode lowestCommonAncestor(ParentNode p, ParentNode q) {
        if(p == null || q == null) return null;
        if(p == q) return p.parent;

        ParentNode root = p;

        while(root.parent != null) root = root.parent;

        ParentNode lca = findLca(root, p, q);

        return hasP == true && hasQ == true ? lca : null;
    }

    private ParentNode findLca(ParentNode root, ParentNode p, ParentNode q) {
        if(root == null) return null;

        ParentNode leftLca = findLca(root.left, p, q);
        ParentNode rightLca = findLca(root.right, p, q);

        if(hasP == false && root.val == p.val) {
            hasP = true;
        }
        if(hasQ == false && root.val == p.val) {
            hasQ = true;
        }

        if(root.val == p.val || root.val == q.val) return root;

        if(leftLca != null && rightLca != null) return root;
        if(leftLca == null && rightLca == null) return null;

        return leftLca != null ? leftLca : rightLca;
    }
}
