/**
* Search in Linked List
* Link : https://www.geeksforgeeks.org/problems/search-in-linked-list-1664434326/1
* Topic : Linked List
*/
/*
class Node {
  public:
    int data;
    Node* next;

    Node(int x) {
        data = x;
        next = NULL;
    }
}; */

class Solution {
    public boolean searchKey(Node head, int key) {

        Node node = head;

        while (node != null) {

            if (node.data == key) {
                return true;
            }

            node = node.next;
        }

        return false;
    }
}
