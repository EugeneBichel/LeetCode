package com.bichel.leetcode.tree;

import com.bichel.leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LowestCommonAncestorOfBinaryTreeIV {
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Map<TreeNode, Boolean> map = new HashMap<>();
        for (int i = 0; i < nodes.length; i++) map.put(nodes[i], false);

        TreeNode lca = findLca(root, map);

        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue().equals(false)) return null;
        }

        return lca;
    }

    private TreeNode findLca(TreeNode root, Map<TreeNode, Boolean> map) {
        if(root == null) return null;

        TreeNode leftLca = findLca(root.left, map);
        TreeNode rightLca = findLca(root.right, map);

        if(map.containsKey(root)) {
            map.put(root, true);

            return root;
        }

        if(leftLca != null && rightLca != null) return root;

        return leftLca != null ? leftLca : rightLca;
    }
}
