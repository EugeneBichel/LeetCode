package com.bichel.java.collections;

abstract class ComparableNode implements Comparable<ComparableNode> {
    public  int frequency; // the frequency of this tree
    public  char data;
    public  ComparableNode left, right;
    public ComparableNode(int freq) {
        frequency = freq;
    }

    // compares on the frequency
    public int compareTo(ComparableNode tree) {
        return frequency - tree.frequency;
    }
}

class HuffmanLeaf extends ComparableNode {
    public HuffmanLeaf(int freq, char val) {
        super(freq);
        data = val;
    }
}

class HuffmanNode extends ComparableNode {
    public HuffmanNode(ComparableNode l, ComparableNode r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }
}

class Decoding {

/*
	class Node
		public  int frequency; // the frequency of this tree
    	public  char data;
    	public  Node left, right;

*/

    void decode(String s, Node root) {

        StringBuilder sb = new StringBuilder();

        if (root == null) {
            System.out.print(sb.toString());
        }

        Node curr = root;

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '1') {
                curr = curr.right;
            } else {
                curr = curr.left;
            }

            if (curr.left == null && curr.right == null) {
                sb.append(curr.data);
                curr = root;
            }
        }

        System.out.print(sb.toString());
    }
}
