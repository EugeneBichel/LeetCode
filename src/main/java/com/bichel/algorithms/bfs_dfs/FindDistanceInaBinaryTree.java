package com.bichel.algorithms.bfs_dfs;

import com.bichel.algorithms.tree.TreeNode;

public class FindDistanceInaBinaryTree {
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode lca = findLca(root, p, q);
        return findDist(lca, p, 0) + findDist(lca, q, 0);
    }

    private int findDist(TreeNode node, int val, int dist) {
        if(node == null) return -1;
        if(node.val == val) return dist;

        int lDist = findDist(node.left, val, dist+1);
        if(lDist == -1)
            return findDist(node.right, val, dist+1);

        return lDist;
    }


    private TreeNode findLca(TreeNode root, int p, int q) {
        if(root == null) return null;

        TreeNode left = findLca(root.left, p, q);
        TreeNode right = findLca(root.right, p, q);

        if(root.val == p || root.val == q || (left != null && right!=null))
            return root;

        return left != null ? left : right;
    }
}
