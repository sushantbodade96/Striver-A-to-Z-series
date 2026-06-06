
public class removeDuplicatesInSortedDLL {

    static class Node {

        int val;
        Node next;
        Node prev;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
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
        Node newNode = new Node(val);
        temp.next = newNode;
        newNode.prev = temp;
        return head;
    }

    static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static Node removeDuplicatesFromSortedDLL(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head;
        Node nextNode = temp.next;
        while (temp != null) {
            while (nextNode != null && temp.val == nextNode.val) {
                nextNode = nextNode.next;
            }
            temp.next = nextNode;
            if (nextNode != null) {
                nextNode.prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head = insertAtEnd(head, 2);
        head = insertAtEnd(head, 2);
        head = insertAtEnd(head, 2);
        head = insertAtEnd(head, 3);
        head = insertAtEnd(head, 4);
        print(head);
        System.out.println();
        Node newHead = removeDuplicatesFromSortedDLL(head);
        print(newHead);
    }
}
