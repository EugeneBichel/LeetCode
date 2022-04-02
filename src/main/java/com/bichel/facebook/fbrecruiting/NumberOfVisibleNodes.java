package com.bichel.facebook.fbrecruiting;

import com.bichel.leetcode.tree.TreeNode;

import java.util.List;
import java.util.ArrayList;

public class NumberOfVisibleNodes {
    public int visibleNodes(TreeNode root) {

        if (root == null)
            return 0;

        List<Integer> items = new ArrayList<>();
        traverse(root, items, 0);

        return items.size();
    }

    private void traverse(TreeNode root, List<Integer> items, int level) {

        if (level == items.size())
            items.add(root.val);

        if (root.left != null)
            traverse(root.left, items, level + 1);
        if (root.right != null)
            traverse(root.right, items, level + 1);
    }
}
