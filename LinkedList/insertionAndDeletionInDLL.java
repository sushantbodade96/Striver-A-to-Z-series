
class Node {

    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

public class insertionAndDeletionInDLL {

    // Print the list
    static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Insert at given index (1-based index)
    static Node insertAtIndex(Node head, int val, int k) {
        Node newNode = new Node(val);

        if (k <= 0) {
            System.out.println("Invalid index");
            return head;
        }

        if (k == 1) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            return newNode;
        }

        Node temp = head;
        int count = 1;

        while (temp != null && count < k - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Index out of bounds");
            return head;
        }

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }

        temp.next = newNode;

        return head;
    }

    // Delete node at given index (1-based index)
    static Node deleteAtIndex(Node head, int k) {
        if (head == null || k <= 0) {
            System.out.println("Invalid index or empty list");
            return head;
        }

        if (k == 1) {
            Node next = head.next;
            if (next != null) {
                next.prev = null;
            }
            return next;
        }

        Node temp = head;
        int count = 1;

        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Index out of bounds");
            return head;
        }

        Node prev = temp.prev;
        Node next = temp.next;

        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = prev;
        }

        return head;
    }

    public static void main(String[] args) {
        // Initial node
        Node head = new Node(5);

        // Insertion
        head = insertAtIndex(head, 7, 1); // Insert at head
        head = insertAtIndex(head, 10, 2); // Insert in middle
        head = insertAtIndex(head, 15, 4); // Insert at end
        print(head); // Output: 7 5 10 15

        // Deletion
        head = deleteAtIndex(head, 2); // Delete node at position 2
        print(head); // Output: 7 10 15

        head = deleteAtIndex(head, 1); // Delete head
        print(head); // Output: 10 15

        head = deleteAtIndex(head, 5); // Invalid
        print(head); // Output: 10 15
    }
}
