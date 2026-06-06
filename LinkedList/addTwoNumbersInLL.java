
class addTwoNumbersInLL {

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

    static Node addTwoNumbers(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node current = dummy;

        Node temp1 = head1;
        Node temp2 = head2;
        int carry = 0;
        int sum = 0;

        while (temp1 != null || temp2 != null) {
            int val1 = (temp1 != null) ? temp1.val : 0;
            int val2 = (temp2 != null) ? temp2.val : 0;
            sum = val1 + val2 + carry;

            carry = sum / 10;
            current.next = new Node(sum % 10);
            current = current.next;

            if (temp1 != null) {
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                temp2 = temp2.next;
            }
        }
        if (carry > 0) {
            current.next = new Node(carry);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1 = insertAtEnd(head1, 2);
        Node head2 = new Node(6);
        head2 = insertAtEnd(head2, 9);
        Node head = addTwoNumbers(head1, head2);
        print(head1);
        System.out.println();
        print(head2);
        System.out.println();
        print(head);
    }

}
