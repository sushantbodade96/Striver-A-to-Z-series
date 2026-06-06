
public class reverseLL {

    static class Node {

        int data;
        Node next;

        Node(int val) {
            this.data = val;
            this.next = null;
        }
    };

    static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node node = null;

        while (head != null) {
            Node temp = head.next;
            head.next = node;
            node = head;
            head = temp;
        }
        return node;
    }

    static Node insertAtEnd(Node head, int val) {
        if (head == null) {
            return new Node(val);
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(val);
        return head;
    }

    static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head = insertAtEnd(head, 6);
        head = insertAtEnd(head, 7);
        head = insertAtEnd(head, 8);
        head = insertAtEnd(head, 9);

        print(head);
        Node newHead = reverse(head);
        System.out.println();
        print(newHead);
    }

}
