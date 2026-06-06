
public class copyOfList {

    static class Node {

        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
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
        // newNode.prev = temp;
        return head;
    }

    static void print(Node head) {
        Node temp = head;
        // int nextVal = 0;
        // int nextRandom = 0;
        while (temp != null) {
            if (temp.next != null && temp.random != null) {
                System.out.print("[" + temp.val + "," + temp.next.val + "," + temp.random.val + "]");
                //  nextVal = temp.next.val;
            } else if (temp.next != null) {
                System.out.println("[" + temp.val + "," + temp.next.val + ",null" + "]");
            } else {
                System.out.println("[" + temp.val + "," + "null," + temp.random.val + "]");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    static Node copyList(Node head) {

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return new Node(head.val);
        }

        //insert nodes in between
        Node temp = head;
        while (temp != null) {
            Node copyNode = new Node(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }

        //copying the random pointer
        // Step 2: Set random pointers of copy nodes
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;  // A'.random = A.random.next
            }
            temp = temp.next.next;
        }

        // Step 3: Separate original and copy lists
        temp = head;
        Node dummy = new Node(0);
        Node copyTail = dummy;

        while (temp != null) {
            Node copy = temp.next;
            copyTail.next = copy;
            copyTail = copy;

            temp.next = copy.next;  // restore original list
            temp = temp.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Step 1: Create original list: 7 → 13 → 11 → 10 → 1
        Node head = new Node(7);
        head = insertAtEnd(head, 13);
        head = insertAtEnd(head, 11);
        head = insertAtEnd(head, 10);
        head = insertAtEnd(head, 1);

        // Store nodes in an array for easy random access
        Node[] nodes = new Node[5];
        Node temp = head;
        int index = 0;
        while (temp != null) {
            nodes[index++] = temp;
            temp = temp.next;
        }

        // Step 2: Assign random pointers (based on LeetCode input [[7,null],[13,0],[11,4],[10,2],[1,0]])
        nodes[0].random = null;
        nodes[1].random = nodes[0]; // 13 → 7
        nodes[2].random = nodes[4]; // 11 → 1
        nodes[3].random = nodes[2]; // 10 → 11
        nodes[4].random = nodes[0]; // 1 → 7

        // Step 3: Print original list
        System.out.println("Original list:");
        print(head);

        // Step 4: Copy list
        Node copiedHead = copyList(head);

        // Step 5: Print copied list
        System.out.println("Copied list:");
        print(copiedHead);
    }

}
/*138. Copy List with Random Pointer
Solved
Medium
Topics
premium lock icon
Companies
Hint
A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.

 

Example 1:


Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
Example 2:


Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
Example 3:



Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]
 

Constraints:

0 <= n <= 1000
-104 <= Node.val <= 104
Node.random is null or is pointing to some node in the linked list. */
