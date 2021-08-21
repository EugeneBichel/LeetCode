package com.bichel.leetcode.bfs_dfs;

import com.bichel.leetcode.graph.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalUsingIteration {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();

        if(root == null) return levels;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {

            List<Integer> level = new ArrayList<>();
            int lenLevel = queue.size();

            for(int i=0; i<lenLevel; i++) {
                TreeNode node = queue.remove();
                level.add(node.val);

                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }

            levels.add(level);
        }

        return levels;
    }

}
