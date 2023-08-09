package com.bichel.algorithms.problemsheap.tree;

import com.bichel.algorithms.problemsheap.graph.NtierNode;

import java.util.ArrayList;

public class SerializeAndDeserializeNaryTree {
    class WrappableInt {
        private int value;
        public WrappableInt(int x) {
            this.value = x;
        }
        public int getValue() {
            return this.value;
        }
        public void increment() {
            this.value++;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(NtierNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    private void dfs(NtierNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        // Add the value of the node
        sb.append((char) (root.val + '0'));

        // Add the number of children
        sb.append((char) (root.children.size() + '0'));

        // Recurse on the subtrees and build the
        // string accordingly
        for (NtierNode child : root.children) {
            this.dfs(child, sb);
        }
    }

    // Decodes your encoded data to tree.
    public NtierNode deserialize(String data) {
        if(data.isEmpty())
            return null;

        return deserialize(data, new WrappableInt(0));
    }

    private NtierNode deserialize(String data, WrappableInt index) {
        if (index.getValue() == data.length()) {
            return null;
        }

        NtierNode node = new NtierNode(
                data.charAt(index.getValue()) - '0',
                new ArrayList<>());
        index.increment();
        int numChildren = data.charAt(index.getValue()) - '0';
        for (int i = 0; i < numChildren; i++) {
            index.increment();
            node.children.add(deserialize(data, index));
        }

        return node;
    }
}
