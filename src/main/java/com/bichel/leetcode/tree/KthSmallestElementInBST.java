package com.bichel.leetcode.tree;

import java.util.List;
import java.util.ArrayList;

public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> items = new ArrayList<>();
        traverse(root, items);

        return items.get(k-1);
    }

    private void traverse(TreeNode root, List<Integer> items) {
        if(root == null) return;

        traverse(root.left, items);
        items.add(root.val);
        traverse(root.right, items);
    }
}
