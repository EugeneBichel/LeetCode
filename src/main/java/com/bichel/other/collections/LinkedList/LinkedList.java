package com.bichel.other.collections.LinkedList;

public class LinkedList {
    public static Node reverse(Node node) {

        Node prev = null;
        Node current = node;
        Node next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        current = prev;

        return current;
    }
}
