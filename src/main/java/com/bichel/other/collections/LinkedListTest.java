/**
 * 1. The "Runner" technique
 * 2. Recursive problems
 */

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList list = new LinkedList("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        list.print();

        list.delete("d");

        list.print();
    }

    static class LinkedList {

        private Node head;

        public LinkedList(String data) {
            head = new Node(data);
        }

        public void add(String data) {
            Node newNode = new Node(data);
            Node currNode = head;

            while (currNode.next != null) {
                currNode = currNode.next;
            }

            currNode.next = newNode;
            System.out.println("currNode.next = " + currNode.next.data);
            System.out.println("head.next = " + head.next.data);
        }

        public Node delete(String data) {

            if(head == null || !head.data.equals(data)) {
                return head;
            }

            if(head.data.equals(data)) {
                return head.next;
            }

            Node currNode = head;

            while(currNode.next != null) {

                if(currNode.next.data.equals(data)) {
                    currNode.next = currNode.next.next;

                    System.out.println("currNode.next = " + currNode.next.data);
                    System.out.println("head.next = " + head.next.data);

                    return head;
                }

                currNode = currNode.next;
            }

            return head;
        }

        public void print() {

            Node currNode = head;

            while(currNode != null) {
                System.out.println(currNode.data);
                currNode = currNode.next;
            }
        }

        private static class Node {
            private String data;
            private Node next;

            Node(final String data) {
                this.data = data;
                this.next = null;
            }
        }
    }
}
