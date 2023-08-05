package com.bichel.java.collections;

import java.util.EmptyStackException;

public class StackTest {
    public static void main(String[] args) {


        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    static class Stack<T> {

        private static class Node<T> {
            private T data;
            private Node<T> next;

            Node(T data) {
                this.data = data;
                next = null;
            }
        }

        private Node<T> top;

        public void push(T data) {
            if(top == null) {
                top = new Node<>(data);
            } else {
                Node<T> newNode = new Node<>(data);
                newNode.next = top;
                top = newNode;
            }
        }

        public T pop() {
            if(top == null) {
                throw new EmptyStackException();
            }

            T data = top.data;
            top = top.next;

            return data;
        }

    }
}
