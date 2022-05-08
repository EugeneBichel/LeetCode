package com.bichel.hackerrank;
import java.util.List;
import java.util.ArrayList;

public class IsBinarySearchTree {
    static boolean checkBST(Node root) {
        if(root == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        inOrderTraverse(root, list);

        for(int i = 0; i < list.size() - 1; i++) {
            if(list.get(i) >= list.get(i+1)) {
                return false;
            }
        }

        return true;
    }

    static void inOrderTraverse(Node root, List<Integer> list) {

        if(root == null) {
            return;
        }

        inOrderTraverse(root.left, list);

        if(root != null) {
            list.add(root.data);
        }

        inOrderTraverse(root.right, list);
    }

    static class Node {
        int data;
        Node left;
        Node right;
    }
}
