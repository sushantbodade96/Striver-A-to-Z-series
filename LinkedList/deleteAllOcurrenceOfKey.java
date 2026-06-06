
public class deleteAllOcurrenceOfKey {

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

    static Node delete(Node head, int val) {
        Node curr = head;

        while (curr != null) {
            if (curr.val == val) {
                Node toDelete = curr;
                curr = curr.next;  // Move ahead before deletion

                // If deleting head node
                if (toDelete.prev == null) {
                    head = toDelete.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } // If deleting tail node
                else if (toDelete.next == null) {
                    toDelete.prev.next = null;
                } // If deleting middle node
                else {
                    toDelete.prev.next = toDelete.next;
                    toDelete.next.prev = toDelete.prev;
                }

                // Help GC
                toDelete.next = null;
                toDelete.prev = null;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head = insertAtEnd(head, 0);
        head = insertAtEnd(head, 0);
        head = insertAtEnd(head, 1);
        head = insertAtEnd(head, 2);
        head = insertAtEnd(head, 1);

        System.out.println("Original list:");
        print(head);

        head = delete(head, 0);
        System.out.println("After deleting all 0s:");
        print(head);

        head = delete(head, 1);
        System.out.println("After deleting all 1s:");
        print(head);
    }
}
