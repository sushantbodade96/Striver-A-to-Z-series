
public class checkPalindrome {

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

    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverse(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public static boolean isPalindrome(Node head) {
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node newHead = reverse(slow.next);
        Node first = head;
        Node second = newHead;
        while (second != null) {
            if (first.val != second.val) {
                // reverse(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        // reverse(newHead);
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head = insertAtEnd(head, 6);
        head = insertAtEnd(head, 7);
        head = insertAtEnd(head, 7);
        head = insertAtEnd(head, 6);
        head = insertAtEnd(head, 8);
        print(head);
        System.out.println("\n" + isPalindrome(head));
    }
}
