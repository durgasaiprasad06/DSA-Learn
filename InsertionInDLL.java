/**
* Insertion at doubly linked list
* Link : https://www.geeksforgeeks.org/problems/insert-a-node-in-doubly-linked-list/1
* Topic : Linked List
*/
/*
class Node {
  public:
    int data;
    Node* next;
    Node* prev;

    Node(int x) {
        data = x;
        next = prev = nullptr;
    }
};
*/

class Solution {
    public Node insertAtPos(Node head, int p, int x) {

        Node curr = head;

        // Reach the pth node
        for (int i = 0; i < p; i++) {
            curr = curr.next;
        }

        // Create new node
        Node newNode = new Node(x);

        // Connect new node with next and previous
        newNode.next = curr.next;
        newNode.prev = curr;

        // Update previous pointer of next node
        if (curr.next != null) {
            curr.next.prev = newNode;
        }

        // Connect current node to new node
        curr.next = newNode;

        return head;
    }
}
