
class Node {

    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
    }
}

public class reverseDLL {

    // Function to print DLL
    static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Function to reverse DLL and return new head
    static Node reverseDLL(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node curr = head;
        Node temp = null;

        while (curr != null) {
            // Swap prev and next
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            // Move to next node (which is previous in original)
            curr = curr.prev;
        }

        // After loop, temp is at the last node, which is new head
        if (temp != null) {
            head = temp.prev;
        }

        return head;
    }

    // Driver code
    public static void main(String[] args) {
        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);

        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;
        third.next = fourth;
        fourth.prev = third;

        System.out.println("Original DLL:");
        print(head);

        head = reverseDLL(head);

        System.out.println("Reversed DLL:");
        print(head);
    }
}
