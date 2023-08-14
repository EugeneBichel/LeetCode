package com.bichel.algorithms.probleamsheap.tree;

import com.bichel.algorithms.problemsheap.tree.algorithms.traversal.MorrisTraversal;
import com.bichel.algorithms.problemsheap.tree.datastructure.TreeNode;
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
