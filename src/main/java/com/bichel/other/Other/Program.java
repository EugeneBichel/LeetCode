package com.bichel.other.Other;

import com.bichel.other.collections.DisjointSets.DisjointSet;

import java.util.Scanner;
import java.util.Stack;


public class Program {

    class Node {
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public int data;
        public Node left;
        public Node right;
    }

    private Node add(Integer value, Node node) {
        if(node == null) {
            node = new Node(value);
            return node;
        }

        if(node.data > value) {
            if(node.left == null) {
                node.left = new Node(value);
            }
            else {
                add(value, node.left);
            }
        } else if(node.data < value) {
            if(node.right == null) {
                node.right = new Node(value);
            }
            else {
                add(value, node.right);
            }
        }

        return node;
    }

    private Node createBST(int[] values, Node node) {
        int n = values.length;

        Node newNode = node;

        for(int i = 0; i < n; i++) {
            newNode = add(values[i], newNode);
        }

        return newNode;
    }

    public static void main(String[] args) {
        int[] arr = {2, 38, 27, 43, 3, 82, 9, 10, 4};

        //Program pr = new Program();
        //Node node = null;
        //node = pr.createBST(arr, node);

        DisjointSet set = new DisjointSet(60);

        for(int i = 1; i <= 60; i++) {
            set.makeSet(i);
        }
/*
        set.union(2, 10);
        set.union(7, 5);
        set.union(6, 1);
        set.union(3, 4);
        set.union(5, 11);
        set.union(7, 8);
        set.union(7, 3);
        set.union(12, 2);
        set.union(9, 6);
*/
        for(int i = 1; i <= 30; i++) {
            set.unionWithPathCompression(i, 2*i);
        }
        for(int i = 1; i <= 20; i++) {
            set.unionWithPathCompression(i, 3*i);
        }
        for(int i = 1; i <= 12; i++) {
            set.unionWithPathCompression(i, 5*i);
        }
        for(int i = 1; i <= 60; i++) {
            System.out.print(' ');
            System.out.print(set.rank[i]);
        }


  /*      System.out.print(set.find(6));
        System.out.print(set.find(3));
        System.out.print(set.find(11));
        System.out.print(set.find(9));
*/
        //System.out.print(arr);

        //Selection.sort(arr);

        //Insertion.sort(arr);

        //MergeSort.sort(arr);

        //Shell.sort(arr);

        /*Stack<Integer> S = new Stack<Integer>();
        S.push(4);
        S.push(10);
        S.push(9);
        S.push(82);
        S.push(3);
        S.push(43);
        S.push(27);
        S.push(38);
        S.push(2);
        StackSort.sort(S);

        //Utility.print(arr);
        Utility.printStack(S);*/

        //QuickSort.sort(arr);

        //Bubble.sort(arr);

        //int[] a = {2, 38, 27, 43, 3, 82, 9, 10, 4};
        //int range = 100;
        //a = Counting.sort(a, range);
        //Utility.print(a);

        //Utility.print(arr);
/*
        Node head = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        four.next = null;
        three.next = four;
        two.next = three;
        head.next = two;

        head = LinkedList.reverse(head);

        while(head != null) {
            System.out.print(head.data);
            head = head.next;
        }

        */



        Scanner s = new Scanner(System.in);
        System.out.println(s.next());
    }
}
