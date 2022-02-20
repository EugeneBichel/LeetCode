package com.bichel.leetcode.tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTreeTest {
    @Test
    public void test1() {

        FindLeavesOfBinaryTree pr = new FindLeavesOfBinaryTree();

        //1 2 3 4 5
        TreeNode root = pr.insertNode(null, 3);
        pr.insertNode(root, 2);
        pr.insertNode(root, 4);
        pr.insertNode(root, 1);
        pr.insertNode(root, 5);

        List<List<Integer>> leafLevels = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            List<Integer> leaves = new ArrayList<>();
            pr.findLeaves(root, leaves);
            leafLevels.add(new ArrayList<>(leaves));
            curr = pr.removeLeaves(curr, leaves);
        }
    }
}
