
import java.util.HashMap;

public class pairWithGivenSum {

    static class Node {

        int val;
        Node next;
        Node prev;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
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
        newNode.prev = temp;
        return head;
    }

    static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static Node findTail(Node head) {
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    static HashMap<Integer, Integer> sumPairs(Node head, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Node left = head;
        Node right = findTail(head);
        while (left.val < right.val) {
            if (left.val + right.val == sum) {
                map.put(left.val, right.val);
                left = left.next;
                right = right.prev;
            } else if (left.val + right.val < sum) {
                left = left.next;
            } else {
                right = right.prev;
            }
        }

        return map;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head = insertAtEnd(head, 2);
        head = insertAtEnd(head, 3);
        head = insertAtEnd(head, 4);
        head = insertAtEnd(head, 5);
        head = insertAtEnd(head, 6);
        print(head);
        System.out.println();
        HashMap<Integer, Integer> map = sumPairs(head, 7);
        for (int key : map.keySet()) {
            System.out.print("[" + key + "," + map.get(key) + "]");
        }

        // System.out.println("Original list:");
        // print(head);
        // head = delete(head, 0);
        // System.out.println("After deleting all 0s:");
        // print(head);
        // head = delete(head, 1);
        // System.out.println("After deleting all 1s:");
        // print(head);
    }
}
/*Find Pairs with Given Sum in Doubly Linked List


0

100
Given the head of a sorted doubly linked list of positive distinct integers, and a target integer, return a 2D array containing all unique pairs of nodes (a, b) such that a + b == target.



Each pair should be returned as a 2-element array [a, b] with a < b. The list is sorted in ascending order. If there are no such pairs, return an empty list.


Examples:
Input: head = [1, 2, 4, 5, 6, 8, 9], target = 7

Output: [[1, 6], [2, 5]]

Explanation: 1 + 6 = 7 and 2 + 5 = 7 are the valid pairs.

Input: head = [1, 5, 6], target = 6

Output: [[1, 5]]

Explanation: 1 + 5 = 6 is the only valid pair. */
