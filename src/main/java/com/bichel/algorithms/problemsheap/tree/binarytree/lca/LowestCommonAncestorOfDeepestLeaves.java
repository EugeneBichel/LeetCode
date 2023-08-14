package com.bichel.algorithms.problemsheap.tree.binarytree.lca;

/*
Given the root of a binary tree, return the lowest common ancestor of its deepest leaves.

Recall that:

The node of a binary tree is a leaf if and only if it has no children
The depth of the root of the tree is 0. if the depth of a node is d,
the depth of each of its children is d + 1.
The lowest common ancestor of a set S of nodes,
is the node A with the largest depth such that every node in S
is in the subtree with root A.
 */

import com.bichel.algorithms.problemsheap.tree.TreeNode;

public class LowestCommonAncestorOfDeepestLeaves {
    private class DeepPair {
        TreeNode node;
        int d;

        public DeepPair(TreeNode node, int d) {
            this.node = node;
            this.d = d;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        DeepPair p = getLca(root, 0);
        return p.node;
    }

    private DeepPair getLca(TreeNode root, int d) {
        if (root == null) return new DeepPair(null, d);
        DeepPair l = getLca(root.left, d + 1);
        DeepPair r = getLca(root.right, d + 1);
        if (l.d == r.d) {
            return new DeepPair(root, l.d);
        } else {
            return l.d > r.d ? l : r;
        }
    }
}
