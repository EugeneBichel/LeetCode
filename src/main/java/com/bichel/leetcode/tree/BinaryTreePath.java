package com.bichel.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class BinaryTreePath {
    private class QNode {
        public TreeNode tNode;
        public StringBuilder sb;

        public QNode(TreeNode tNode, StringBuilder sb) {
            this.tNode = tNode;
            this.sb = sb;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();

        bfs(root, paths);

        return paths;
    }

    private void bfs(TreeNode root, List<String> paths) {

        if (root == null) return;

        StringBuilder sb = new StringBuilder();
        sb.append(root.val);

        Queue<QNode> q = new LinkedList<>();
        q.add(new QNode(root, sb));

        while (!q.isEmpty()) {
            QNode node = q.poll();

            if (node.tNode.left == null && node.tNode.right == null) {
                paths.add(node.sb.toString());
            }

            if (node.tNode.left != null) {
                sb = new StringBuilder(node.sb);
                sb.append("->").append(node.tNode.left.val);
                q.add(new QNode(node.tNode.left, sb));
            }

            if (node.tNode.right != null) {
                sb = new StringBuilder(node.sb);
                sb.append("->").append(node.tNode.right.val);
                q.add(new QNode(node.tNode.right, sb));
            }
        }
    }
}