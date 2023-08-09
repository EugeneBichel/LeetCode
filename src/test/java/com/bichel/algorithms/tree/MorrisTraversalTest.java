package com.bichel.algorithms.tree;

import com.bichel.algorithms.problemsheap.tree.MorrisTraversal;
import com.bichel.algorithms.problemsheap.tree.TreeNode;
import org.junit.jupiter.api.Test;

public class MorrisTraversalTest {
    @Test
    public void test1() {
        MorrisTraversal pr = new MorrisTraversal();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        pr.morris(root);
    }
}
