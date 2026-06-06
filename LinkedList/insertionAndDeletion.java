
class insertionAndDeletion {

    static class Node {

        int val;
        Node next;

        Node(int val) {
            this.val = val;
            next = null;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

    }

    static Node deleteAtIndex(int index, Node head) {
        if (head == null) {
            return null;
        }
        if (index == 1) {
            head = head.next;
            return head;
        }
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            if (count == index - 1) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }

        return head;
    }

    static Node insertAtIndex(int index, Node head, int val) {
        if (index == 1) {
            Node newNode = new Node(val, head);
            head = newNode;
            return head;
        }
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            if (count == (index - 1)) {
                Node newNode = new Node(val);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        head = insertAtIndex(1, head, 7);
        head = insertAtIndex(2, head, 12);
        head = insertAtIndex(3, head, 11);
        head = insertAtIndex(2, head, 89);
        head = insertAtIndex(1, head, 1);

        print(head);
        System.out.println();
        head = deleteAtIndex(1, head);
        print(head);
    }
}
