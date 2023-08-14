package com.bichel.algorithms.problemsheap.tree.algorithms.narytree;

import com.bichel.algorithms.problemsheap.graph.NtierNode;
import com.bichel.algorithms.problemsheap.tree.datastructure.TreeNode;

import java.util.LinkedList;

public class EncodeNaryTreeToBinaryTree {
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(NtierNode root) {
        if (root == null) return null;

        TreeNode ans = new TreeNode(root.val);

        if (root.children.size() > 0) {
            ans.left = encode(root.children.get(0));
        }

        TreeNode cur = ans.left;
        for (int i = 1; i < root.children.size(); i++) {
            cur.right = encode(root.children.get(i));
            cur = cur.right;
        }

        return ans;
    }

    // Decodes your binary tree to an n-ary tree.
    public NtierNode decode(TreeNode root) {
        if (root == null) return null;

        NtierNode t = new NtierNode(root.val, new LinkedList<>());
        TreeNode cur = root.left;
        while (cur != null) {
            t.children.add(decode(cur));
            cur = cur.right;
        }

        return t;
    }
}
