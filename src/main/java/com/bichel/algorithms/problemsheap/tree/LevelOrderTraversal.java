package com.bichel.algorithms.problemsheap.tree;

import java.util.LinkedList;
import java.util.Queue;

class LevelOrderTraversal {
    class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void levelOrder(Node root) {

        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            System.out.print(curr.data);
            System.out.print(" ");

            if (curr.left != null) {
                queue.add(curr.left);
            }

            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }
}
