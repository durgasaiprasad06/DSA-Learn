/**
* Delete in a Singly Linked List
* Link : https://www.geeksforgeeks.org/problems/delete-a-node-in-single-linked-list/1
* Topic : Linked List
*/
/*
class Node {
public:
    int data;
    Node* next;
    Node(int data) {
        this->data = data;
        this->next = nullptr;
    }
};
*/

class Solution {
    public Node deleteNode(Node head, int x) {

        // Delete the first node
        if (x == 1) {
            return head.next;
        }

        Node curr = head;

        // Move to the (x - 1)th node
        for (int i = 1; i < x - 1; i++) {
            curr = curr.next;
        }

        // Delete the xth node
        curr.next = curr.next.next;

        return head;
    }
}
