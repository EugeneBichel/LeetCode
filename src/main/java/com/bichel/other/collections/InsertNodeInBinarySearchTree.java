package com.bichel.other.collections;

import java.util.*;
import java.io.*;

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

    public static void preOrder(Node root) {

        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

 /* Node is defined as :
 class Node
    int data;
    Node left;
    Node right;

    */

    public static Node insert(Node root, int data) {
        // left < parent < right

        if (root == null) {
            return new Node(data);
        }

        Node curr = root;

        while (true) {
            if (curr.data < data) {
                if (curr.right == null) {
                    curr.right = new Node(data);
                    break;
                }
                curr = curr.right;
            } else {
                if (curr.left == null) {
                    curr.left = new Node(data);
                    break;
                }
                curr = curr.left;
            }
        }

        return root;
    }
}