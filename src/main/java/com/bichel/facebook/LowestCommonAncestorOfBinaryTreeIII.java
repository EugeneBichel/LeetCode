package com.bichel.facebook;

import com.bichel.leetcode.graph.ParentNode;

/*
Given two nodes of a binary tree p and q, return their lowest common ancestor (LCA).

Each node will have a reference to its parent node. The definition for Node is below:

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}
According to the definition of LCA on Wikipedia: "The lowest common ancestor of two nodes p and q in a tree T is the lowest node that has both p and q as descendants (where we allow a node to be a descendant of itself)."


 */

public class LowestCommonAncestorOfBinaryTreeIII {
    private boolean hasP, hasQ;

    public ParentNode lowestCommonAncestor(ParentNode p, ParentNode q) {
        if(p == null || q == null) return null;
        if(p == q) return p.parent;

        ParentNode root = p;

        while(root.parent != null)
            root = root.parent;

        ParentNode lca = findLca(root, p, q);

        return hasP && hasQ ? lca : null;
    }

    private ParentNode findLca(ParentNode root, ParentNode p, ParentNode q) {
        if(root == null)
            return null;

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
