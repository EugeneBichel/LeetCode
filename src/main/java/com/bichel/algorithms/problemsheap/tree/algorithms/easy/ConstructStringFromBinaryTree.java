package com.bichel.algorithms.problemsheap.tree.algorithms.easy;

import com.bichel.algorithms.problemsheap.tree.datastructure.TreeNode;

public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traversePreorder(root, sb, null, root);
        return sb.toString();
    }

    private void traversePreorder(TreeNode node, StringBuilder sb, TreeNode parent, TreeNode root) {
        if(parent != null && parent.right != null && parent.left == null && node == null) {
            sb.append("()");
            return;
        } else if(node == null) {
            return;
        }

        if(sb.isEmpty()) {
            sb.append(node.val);
        } else {
            sb.append('(').append(node.val);
        }

        traversePreorder(node.left, sb, node, root);
        traversePreorder(node.right, sb, node, root);

        if(node != root) {
            sb.append(')');
        }
    }
}
