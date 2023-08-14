package com.bichel.algorithms.problemsheap.tree.algorithms.binarytree;

import com.bichel.algorithms.problemsheap.tree.datastructure.TreeNode;

import java.util.List;
import java.util.ArrayList;

/*
Given the roots of two binary trees p and q,
write a function to check if they are the same or not.

Two binary trees are considered the same
if they are structurally identical, and the nodes have the same value.
 */

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> pList = new ArrayList<>();
        List<Integer> qList = new ArrayList<>();

        inOrder(p, pList);
        inOrder(q, qList);

        return pList.equals(qList);
    }

    private void inOrder(TreeNode node, List<Integer> items) {
        if(node == null) {
            items.add(null);
            return;
        }

        items.add(node.val);
        inOrder(node.left, items);
        inOrder(node.right, items);
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null) {
            return true;
        }

        // one of p and q is null
        if (q == null || p == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree2(p.right, q.right) &&
                isSameTree2(p.left, q.left);
    }
}
