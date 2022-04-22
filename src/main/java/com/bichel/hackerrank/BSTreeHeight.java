package com.bichel.hackerrank;
/*
public class BSTreeHeight {

    public static int getHeight(Node root){
        //Write your code here
        return dist(root, 0);
    }

    public static int dist(Node root, int d) {
        if(root == null) {
            return d;
        }
        if(root.left == null && root.right == null) {
            return d;
        }

        int left = dist(root.left, d + 1);
        int right = dist(root.right, d + 1);

        if(left > right) {
            d = left;
        } else {
            d = right;
        }

        return d;
    }
}
*/