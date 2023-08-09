package com.bichel.algorithms.problemsheap;

import java.util.HashMap;
import java.util.Map;

/*
A linked list of length n is given such that each node contains
an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list.

Time Complexity: O(N) where N is the number of nodes in the linked list.
Space Complexity: O(N). If we look closely,
we have the recursion stack and we also have the space complexity
to keep track of nodes already cloned i.e. using the visited dictionary.
But asymptotically, the complexity is O(N).
 */

public class CopyListWithRandomPointer {
    Map<RandomNode, RandomNode> visitedHash = new HashMap<>();

    public RandomNode copyRandomList(RandomNode head) {
        if (head == null) {
            return null;
        }

        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);
        }

        RandomNode node = new RandomNode(head.val);
        this.visitedHash.put(head, node);

        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);

        return node;
    }
}
