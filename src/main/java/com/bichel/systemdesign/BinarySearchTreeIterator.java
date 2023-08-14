package com.bichel.systemdesign;

import com.bichel.algorithms.problemsheap.tree.datastructure.TreeNode;

import java.util.Stack;

public class BinarySearchTreeIterator {
    Stack<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        // Stack for the recursion simulation
        this.stack = new Stack<TreeNode>();

        // Remember that the algorithm starts with a call to the helper function
        // with the root node as the input
        _leftmostInorder(root);
    }

    private void _leftmostInorder(TreeNode root) {

        // For a given node, add all the elements in the leftmost branch of the tree
        // under it to the stack.
        while (root != null) {
            this.stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode topmostNode = this.stack.pop();

        // Need to maintain the invariant. If the node has a right child, call the
        // helper function for the right child
        if (topmostNode.right != null) {
            this._leftmostInorder(topmostNode.right);
        }

        return topmostNode.val;
    }

    public boolean hasNext() {
        return this.stack.size() > 0;
    }
}
