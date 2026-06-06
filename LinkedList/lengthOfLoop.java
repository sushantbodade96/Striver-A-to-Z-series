
public class lengthOfLoop {

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
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
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    static int length(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int count = 1;
                fast = fast.next;
                while (slow != fast) {
                    count++;
                    fast = fast.next;
                }
                return count;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head = insertAtEnd(head, 6);
        head = insertAtEnd(head, 7);
        head = insertAtEnd(head, 8);
        head = insertAtEnd(head, 9);
        head = insertAtEnd(head, 10);

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;

        System.out.println(length(head));
    }

}
