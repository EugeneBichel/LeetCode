package com.bichel.algorithms;

import com.bichel.algorithms.NaryTreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CloneNAryTree {
    private Map<NaryTreeNode, NaryTreeNode> visitedMap = new HashMap<>();

    public NaryTreeNode cloneTree(NaryTreeNode root) {
        if(root == null) return null;

        if(visitedMap.containsKey(root)) return visitedMap.get(root);

        NaryTreeNode clonedNode = new NaryTreeNode(root.val, new ArrayList<>());
        visitedMap.put(root, clonedNode);

        for(NaryTreeNode node: root.children)
            clonedNode.children.add(cloneTree(node));

        return clonedNode;
    }
}
