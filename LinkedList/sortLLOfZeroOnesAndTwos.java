
public class sortLLOfZeroOnesAndTwos {

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

    static Node sort(Node head) {
        Node zeroHead = new Node(-1);
        Node zero = zeroHead;
        Node oneHead = new Node(-1);
        Node one = oneHead;
        Node twoHead = new Node(-1);
        Node two = twoHead;

        Node temp = head;
        while (temp != null) {
            if (temp.val == 0) {
                zero.next = temp;
                zero = zero.next;
                temp = temp.next;
            } else if (temp.val == 1) {
                one.next = temp;
                one = one.next;
                temp = temp.next;
            } else {
                two.next = temp;
                two = two.next;
                temp = temp.next;
            }
        }
        zero.next = oneHead.next;
        one.next = twoHead.next;
        two.next = null;
        return zeroHead.next;

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head = insertAtEnd(head, 0);
        head = insertAtEnd(head, 0);
        head = insertAtEnd(head, 1);
        head = insertAtEnd(head, 2);
        head = insertAtEnd(head, 1);
        print(head);
        System.out.println();
        Node newhead = sort(head);
        print(newhead);
    }
}
