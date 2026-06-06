
public class deleteNAfterM {

    static class Node {

        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static Node deleteNnodesAfterMnodes(Node head, int n, int m) {
        if (head == null || m == 0) {
            return null;
        }
        if (n == 0) {
            return head;
        }

        Node currNode = head;
        while (currNode != null) {

            for (int i = 1; i < m && currNode != null; i++) {
                currNode = currNode.next;
            }
            if (currNode == null) {
                break;
            }
            Node temp = currNode.next;
            for (int i = 0; i < n && temp != null; i++) {
                temp = temp.next;
            }
            currNode.next = temp;
            currNode = temp;
        }
        return head;
    }

    static void print(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);
        print(head);
        System.out.println();
        head = deleteNnodesAfterMnodes(head, 3, 2);
        print(head);

    }

}
