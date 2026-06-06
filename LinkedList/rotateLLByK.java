
public class rotateLLByK {

    static class Node {

        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    };

    static Node insertAtEnd(Node head, int val) {
        Node temp = head;
        if (temp == null) {
            return new Node(val);
        }
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

    public static int length(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;

    }

    public static Node rotateRight(Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int n = length(head);
        k = k % n;
        if (k == 0) {
            return head;
        }
        int m = n - k;
        Node temp = head;
        m--;
        while (m > 0) {
            m--;
            temp = temp.next;
        }
        Node tail = temp;
        Node front = temp.next;

        while (tail.next != null) {
            tail = tail.next;
        }
        temp.next = null;
        tail.next = head;
        head = front;
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head = insertAtEnd(head, 6);
        head = insertAtEnd(head, 7);
        head = insertAtEnd(head, 8);
        head = insertAtEnd(head, 9);

        print(head);
        Node newHead = rotateRight(head, 2);
        System.out.println();
        print(newHead);
    }
}
