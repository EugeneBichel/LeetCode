package com.bichel.leetcode.bfs_dfs;

import com.bichel.leetcode.graph.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalUsingRecursion {
    List<List<Integer>> levels = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return levels;
        }
        bfs(root, 0);

        return levels;
    }

    private void bfs(TreeNode root, int level) {

        if(root == null) return;

        if(levels.size() == level) {
            levels.add(new ArrayList<>());
        }

        levels.get(level).add(root.val);

        if(root.left != null) bfs(root.left, level+1);
        if(root.right != null) bfs(root.right, level+1);
    }
}
