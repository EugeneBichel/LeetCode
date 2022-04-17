package com.bichel.leetcode.tree;

/*
Implement the BSTIterator class
 that represents an iterator over the in-order traversal of a binary search tree (BST):

BSTIterator(TreeNode root) Initializes an object of the BSTIterator class.
The root of the BST is given as part of the constructor. The pointer should be initialized
to a non-existent number smaller than any element in the BST.
boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer,
otherwise returns false.
int next() Moves the pointer to the right, then returns the number at the pointer.
boolean hasPrev() Returns true if there exists a number in the traversal to the left of the pointer,
otherwise returns false.
int prev() Moves the pointer to the left, then returns the number at the pointer.
Notice that by initializing the pointer to a non-existent smallest number,
the first call to next() will return the smallest element in the BST.

You may assume that next() and prev() calls will always be valid.
That is, there will be at least a next/previous number in the in-order traversal
when next()/prev() is called.
 */

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIteratorII {
    List<Integer> arr = new ArrayList();
    int pointer;
    int n;

    private void inorder(TreeNode r, List<Integer> arr) {
        if (r == null) return;
        inorder(r.left, arr);
        arr.add(r.val);
        inorder(r.right, arr);
    }

    public BinarySearchTreeIteratorII(TreeNode root) {
        inorder(root, arr);
        n = arr.size();
        pointer = -1;
    }

    public boolean hasNext() {
        return pointer < n - 1;
    }

    public int next() {
        ++pointer;
        return arr.get(pointer);
    }

    public boolean hasPrev() {
        return pointer > 0;
    }

    public int prev() {
        --pointer;
        return arr.get(pointer);
    }
}
