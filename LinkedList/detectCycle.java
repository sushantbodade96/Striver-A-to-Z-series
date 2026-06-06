
class detectCycle {

    static class Node {

        int data;
        Node next;

        Node(int val) {
            this.data = val;
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

    public static boolean hasCycle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // public static boolean hasCycle(Node head) {
    //     HashSet<Node> set = new HashSet<>();
    //     Node temp = head;
    //     while (temp != null) {
    //         if (set.contains(temp)) {
    //             return true;
    //         } else {
    //             set.add(temp);
    //             temp = temp.next;
    //         }
    //     }
    //     return false;
    // }
    public static void main(String[] args) {
        Node head = new Node(5);
        head = insertAtEnd(head, 6);
        head = insertAtEnd(head, 7);
        head = insertAtEnd(head, 8);
        head = insertAtEnd(head, 9);

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;

        System.out.println(hasCycle(head));

        // print(head);
        // Node newHead = reverse(head);
        // System.out.println();
        // print(newHead);
    }
}
