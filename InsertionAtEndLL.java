/**
* Linked List End Insertion
* Link : https://www.geeksforgeeks.org/problems/linked-list-insertion-1587115620/1
* Topic : Linked List
*/


/*Structure of the linked list node is as
struct Node {
  int data;
  struct Node * next;
  Node(int x) {
    data = x;
    next = NULL;
  }
}; */


class Solution {
    public Node insertAtEnd(Node head, int x) {

        // If list is empty
        if (head == null) {
            return new Node(x);
        }

        // Traverse to the last node
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        // Create new node
        Node p = new Node(x);

        // Attach new node at the end
        temp.next = p;

        return head;
    }
}
