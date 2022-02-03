package com.bichel.leetcode.tree;

import com.bichel.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MinimumDistanceBetweenBSTNodes {
    public static void main(String[] args) {

    }
    private static int minDiffInBST(TreeNode root) {
        List<Integer> items = new ArrayList<>();
        traverse(root, items);

        int min = Integer.MAX_VALUE;
        for(int i=1;i<items.size();i++) {
            min = Math.min(min, items.get(i) - items.get(i-1));
        }

        return min;
    }

    private static void traverse(TreeNode root, List<Integer> items) {
        if(root == null) return;

        traverse(root.left, items);
        items.add(root.val);
        traverse(root.right, items);
    }
}