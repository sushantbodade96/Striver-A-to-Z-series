
public class add1inANumberRepresentedByLL {

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

    static int helper(Node temp) {
        if (temp == null) {
            return 1;
        }
        int carry = helper(temp.next);
        temp.val = temp.val + carry;
        if (temp.val > 9) {
            temp.val = 0;
            return 1;
        } else {
            // temp.val = temp.val + 1;
            return 0;
        }

    }

    static Node addOne(Node head) {
        Node temp = head;
        int carry = helper(temp);
        if (carry == 1) {
            Node newNode = new Node(1);
            newNode.next = head;
            head = newNode;
            return head;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(9);
        head = insertAtEnd(head, 9);
        head = insertAtEnd(head, 9);
        print(head);
        Node newHead = addOne(head);
        System.out.println();
        print(newHead);
    }
}
