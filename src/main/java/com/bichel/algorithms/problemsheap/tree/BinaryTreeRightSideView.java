package com.bichel.algorithms.problemsheap.tree;

import com.bichel.algorithms.problemsheap.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree, imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom.

Complexity Analysis

Time complexity: O(N) since one has to visit each node.

Space complexity: )(H) to keep the recursion stack,
where H is a tree height. The worst-case situation is a skewed tree, when H = N.
 */

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    private void dfs(TreeNode node, int level, List<Integer> ans) {
        if (node == null) return;

        if (level == ans.size())
            ans.add(node.val);

        if (node.right != null) {
            dfs(node.right, level + 1, ans);
        }
        if (node.left != null) {
            dfs(node.left, level + 1, ans);
        }
    }
}
