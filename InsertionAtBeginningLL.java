/**
* Linked List Insertion At Beginning
* Link : https://www.geeksforgeeks.org/problems/linked-list-insertion-at-beginning/1
* Topic : Linked List
*/
/*

/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node insertAtFront(Node head, int x) {

        // Create new node
        Node node = new Node(x);

        // Point new node to current head
        node.next = head;

        // New node becomes the head
        return node;
    }
}
