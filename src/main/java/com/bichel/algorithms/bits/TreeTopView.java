package com.bichel.algorithms.bits;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

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

class Solution {

    /*

    class Node
        int data;
        Node left;
        Node right;
    */
    public static void topView(Node root) {
        if (root == null) {
            return;
        }

        class QNode {
            Node node;
            int length;

            QNode(Node node, int length) {
                this.node = node;
                this.length = length;
            }
        }

        Queue<QNode> queue = new LinkedList<>();
        Map<Integer, Node> map = new TreeMap<>();

        queue.add(new QNode(root, 0));

        while (!queue.isEmpty()) {
            QNode curr = queue.poll();
            if (!map.containsKey(curr.length)) {
                map.put(curr.length, curr.node);
            }

            if (curr.node.left != null) {
                queue.add(new QNode(curr.node.left, curr.length - 1));
            }

            if (curr.node.right != null) {
                queue.add(new QNode(curr.node.right, curr.length + 1));
            }
        }

        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            System.out.print(entry.getValue().data);
            System.out.print(" ");
        }
    }
}
