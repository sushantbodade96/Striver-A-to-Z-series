
public class flateningLL {

    static class Node {

        int val;
        Node next;
        Node child;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.child = null;
        }
    };

    static void printChildren(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.child;
        }
    }

    static Node flattenLL(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newNode = flattenLL(head.next);
        return merge(head, newNode);
    }

    static Node merge(Node head, Node newNode) {
        Node dummy = new Node(-1);
        Node res = dummy;

        while (head != null && newNode != null) {
            if (head.val < newNode.val) {
                res.child = head;
                res = res.child;
                head = head.child;
            } else {
                res.child = newNode;
                res = res.child;
                newNode = newNode.child;
            }
            res.next = null;

        }
        if (head != null) {
            res.child = head;
        } else {
            res.child = newNode;
        }
        return dummy.child;

    }

    public static void main(String[] args) {
        // Head nodes
        Node head1 = new Node(1);
        Node head2 = new Node(3);
        Node head3 = new Node(5);

        // Link heads
        head1.next = head2;
        head2.next = head3;

        // Child lists (already sorted)
        head1.child = new Node(2);
        head2.child = new Node(4);
        head3.child = new Node(6);

        Node result = flattenLL(head1);
        printChildren(result);  // Output: 1 2 3 4 5 6
    }
}
/*
 * Given a special linked list containing n head nodes where every node in the linked list contains two pointers:

‘Next’ points to the next node in the list
‘Child’ pointer to a linked list where the current node is the head
Each of these child linked lists is in sorted order and connected by a 'child' pointer.



Flatten this linked list such that all nodes appear in a single sorted layer connected by the 'child' pointer and return the head of the modified list.


Examples:
Input:
1->2->3->4
|  |  |  |
4  5  6  7
|  |  |   |
2   null  null


Output: head -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> 11 -> 12

Explanation: All the linked lists are joined together and sorted in a single level through the child pointer.

Input:



Output: head -> 2 -> 4 -> 5 -> 10 -> 12 -> 13 -> 16 -> 17 -> 20

Explanation: All the linked lists are joined together and sorted in a single level through the child pointer.

Constraints:
n == Number of head nodes
1 <= n <= 100
1 <= Number of nodes in each child linked list <= 100
0 <= ListNode.val <= 1000
All child linked lists are sorted in non-decreasing order
 */
