//Implementation of a LinkedList data structure using Nodes
public class LinkedList {
    Node head; // head of list

    // Linked list Node.
    static class Node {

        int data;
        Node next;

        // Constructor to create a new node - Next initialized to null
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Constructor to create a new linked list with given node as head of list
    public LinkedList(Node n){
        head = n;
    }

    // Input: data: data for new node
    // Output: creat and insert the new node to the list
    // Running Time: O(n) where n current size of list (O(1) for an empty list)
    public void insert(int data)
    {
        Node new_node = new Node(data);
        new_node.next = null;

        // If the Linked List is empty, make the new node as head
        if (this.head == null) {
            this.head = new_node;
        }
        else {
            // go to the last node and insert the new node there
            Node last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            // Insert the new node at last node
            last.next = new_node;
        }
    }

    // Method to print the LinkedList.
    public static void printList(LinkedList list)
    {
        Node currNode = list.head;
        // go through the LinkedList
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

}
