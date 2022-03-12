package com.bichel.facebook;

public class CloneBinaryTreeWithRandomPointer {
   /* private Map<Node, NodeCopy> visitedMap = new HashMap<>();

    public NodeCopy copyRandomBinaryTree(Node root) {
        if(root == null) return null;
        if(visitedMap.containsKey(root)) return visitedMap.get(root);

        NodeCopy clonedNode = new NodeCopy(root.val);
        visitedMap.put(root, clonedNode);

        clonedNode.left = copyRandomBinaryTree(root.left);
        clonedNode.right = copyRandomBinaryTree(root.right);
        clonedNode.random = copyRandomBinaryTree(root.random);

        return clonedNode;
    }

    */
}
