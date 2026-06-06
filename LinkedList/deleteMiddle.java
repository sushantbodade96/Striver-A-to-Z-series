
public class deleteMiddle {

    static class Node {

        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    };

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
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static Node deleteMiddle(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head.next.next;
        // Node prev = head;

        while (fast != null && fast.next != null) {
            // prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // if(prev.next != null)
        slow.next = slow.next.next;
        return head;

    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head = insertAtEnd(head, 6);
        head = insertAtEnd(head, 7);
        head = insertAtEnd(head, 8);
        head = insertAtEnd(head, 9);
        head = insertAtEnd(head, 10);
        print(head);
        System.out.println();
        Node newhead = deleteMiddle(head);
        print(newhead);
    }
}
