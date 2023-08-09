package com.bichel.algorithms.problemsheap.tree;

import java.util.*;
import java.io.*;

public class tree_orders {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	class Node {
    	public int data;
    	public Node left;
    	public Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

    	public Node(int data, Node left, Node right) {
    		this.data = data;
    		this.left = left;
    		this.right = right;
		}
	}

	public class TreeOrders {
		int n;
		int[] key, left, right;
		Node root;

		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			key = new int[n];
			left = new int[n];
			right = new int[n];
			for (int i = 0; i < n; i++) {
				key[i] = in.nextInt();
				left[i] = in.nextInt();
				right[i] = in.nextInt();
			}

			root = createTree(root, 0);
		}

		Node createTree(Node node, int index) {
			if(node == null) {
				node = new Node(key[index]);
			}

			if(left[index] != -1) {
				node.left = createTree(node.left, left[index]);
			}

			if(right[index] != -1) {
				node.right = createTree(node.right, right[index]);
			}

			return node;
		}

		List<Integer> inOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();

			inOrderTraverse(root, result);

			return result;
		}

		void inOrderTraverse(Node node, ArrayList<Integer> result) {
			if(node == null) {
				return;
			}

			if(node.left != null) {
				inOrderTraverse(node.left, result);
			}

			result.add(node.data);

			if(node.right != null) {
				inOrderTraverse(node.right, result);
			}
		}

		void preOrderTraverse(Node node, ArrayList<Integer> result) {
			if(node == null) {
				return;
			}

			result.add(node.data);

			if(node.left != null) {
				preOrderTraverse(node.left, result);
			}
			if(node.right != null) {
				preOrderTraverse(node.right, result);
			}
		}

		void postOrderTraverse(Node node, ArrayList<Integer> result) {
			if(node == null) {
				return;
			}

			if(node.left != null) {
				postOrderTraverse(node.left, result);
			}

			if(node.right != null) {
				postOrderTraverse(node.right, result);
			}

			result.add(node.data);
		}

		List<Integer> preOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			preOrderTraverse(root, result);
			return result;
		}

		List<Integer> postOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			postOrderTraverse(root, result);
			return result;
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_orders().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}

	public void print(List<Integer> x) {
		for (Integer a : x) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public void run() throws IOException {
		TreeOrders tree = new TreeOrders();
		tree.read();
		print(tree.inOrder());
		print(tree.preOrder());
		print(tree.postOrder());
	}
}
