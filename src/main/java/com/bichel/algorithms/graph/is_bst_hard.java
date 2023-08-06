package com.bichel.algorithms.graph;

import java.util.*;
import java.io.*;

public class is_bst_hard {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public class IsBST {
        class Node {
            int key;
            int left;
            int right;

            Node(int key, int left, int right) {
                this.left = left;
                this.right = right;
                this.key = key;
            }
        }

        class TreeNode {
            int key;
            TreeNode left;
            TreeNode right;

            TreeNode(int key) {
                this.left = null;
                this.right = null;
                this.key = key;
            }
        }

        int nodes;
        Node[] tree;
        TreeNode root;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            nodes = in.nextInt();
            tree = new Node[nodes];
            for (int i = 0; i < nodes; i++) {
                tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
            }

            if(nodes > 0) {
                root = createTree(root, 0);
            }
        }

        TreeNode createTree(TreeNode node, int index) {
            if(node == null) {
                node = new TreeNode(tree[index].key);
            }

            if(tree[index].left != -1) {
                node.left = createTree(node.left, tree[index].left);
            }

            if(tree[index].right != -1) {
                node.right = createTree(node.right, tree[index].right);
            }

            return node;
        }

        List<Integer> inOrder() {
            ArrayList<Integer> result = new ArrayList<Integer>();

            inOrderTraverse(root, result);

            return result;
        }

        void inOrderTraverse(TreeNode node, ArrayList<Integer> result) {
            if(node == null) {
                return;
            }

            if(node.left != null) {
                if(node.left.key == node.key) {
                    node.left.key = -2;
                }
                inOrderTraverse(node.left, result);
            }

            result.add(node.key);

            if(node.right != null) {
                inOrderTraverse(node.right, result);
            }
        }

        boolean isBinarySearchTree() {
            if (nodes == 0) {
                return true;
            }

            List<Integer> result = inOrder();

            for (int i = 1; i < result.size(); i++) {
                if(result.get(i - 1) == -2 || result.get(i) == -2) {
                    return false;
                }
                if (result.get(i) < result.get(i - 1)) {
                    return false;
                }
            }

            return true;
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new is_bst_hard().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        IsBST tree = new IsBST();
        tree.read();
        if (tree.isBinarySearchTree()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }
}
