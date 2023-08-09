package com.bichel.algorithms.problemsheap.tree;

import com.bichel.algorithms.problemsheap.NaryTreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;
import java.util.List;

public class NaryTreePreorderTraversal {
    public List<Integer> preorder(NaryTreeNode root) {
        Stack<NaryTreeNode> stack = new Stack<>();
        LinkedList<Integer> output = new LinkedList<>();

        if (root == null) {
            return output;
        }

        stack.push(root);

        while (!stack.isEmpty()) {
            NaryTreeNode node = stack.pop();
            output.add(node.val);

            Collections.reverse(node.children);

            for (NaryTreeNode item : node.children) {
                stack.add(item);
            }
        }

        return output;
    }
}
