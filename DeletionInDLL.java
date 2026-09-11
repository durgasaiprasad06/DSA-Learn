/**
 * Delete in a Doubly Linked List
 * Link : https://www.geeksforgeeks.org/problems/delete-node-in-doubly-linked-list/1
 * Topic : Linked List
 */

/* Structure of Node
class Node {
    int data;
    Node next;
    Node prev;

    Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/

class Solution {
    // Function to delete a node at given position.
    public Node deleteNode(Node head, int x) {
        if (head == null) {
            return null;
        }

        // Case 1: Deleting the head node (position 1)
        if (x == 1) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return head;
        }

        // Traverse to the x-th node (1-based index)
        Node temp = head;
        for (int i = 1; i < x && temp != null; i++) {
            temp = temp.next;
        }

        // If x is beyond the length of the list
        if (temp == null) {
            return head;
        }

        // Case 2: Deleting the last node
        if (temp.next == null) {
            temp.prev.next = null;
        } 
        // Case 3: Deleting an internal node
        else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        return head;
    }
}
