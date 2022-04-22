public class ReverseLinkedListTest {
    public static Node reverse(Node node) {

        Node prev = null;
        Node current = node;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;

            prev = current;
            current = next;
        }

        current = prev;

        return current;
    }

    private static class Node {

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public int data;
        public Node next;
    }
}
