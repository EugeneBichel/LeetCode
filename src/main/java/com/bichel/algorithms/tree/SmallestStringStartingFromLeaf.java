package com.bichel.algorithms.tree;

/*
You are given the root of a binary tree where each node has a value in the range [0, 25] representing the letters 'a' to 'z'.

Return the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

As a reminder, any shorter prefix of a string is lexicographically smaller.

For example, "ab" is lexicographically smaller than "aba".
A leaf of a node is a node that has no children.
 */

public class SmallestStringStartingFromLeaf {
    String ans = "~";

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        if (node == null)
            return;

        sb.append((char) ('a' + node.val));

        if (node.left == null && node.right == null) {
            sb.reverse();
            String str = sb.toString();
            sb.reverse();

            if (str.compareTo(ans) < 0)
                ans = str;
        }

        dfs(node.left, sb);
        dfs(node.right, sb);

        sb.deleteCharAt(sb.length() - 1);
    }
}
