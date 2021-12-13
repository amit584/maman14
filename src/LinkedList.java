// Java program to implement
// a Singly Linked List

import com.sun.jdi.connect.spi.TransportService;

public class LinkedList {
    Node head; // head of list

    /* Linked list Node.
    This inner class is made static
    so that main() can access it*/
    static class Node {

        int data;
        Node next;

        // Constructor
        Node(int d) {
            data = d;
            next = null;
        }
    }
    public LinkedList(Node n){
        head = n;
    }

    // Method to insert a new node
    public void insert(int data)
    {
        // Create a new node with given data
        Node new_node = new Node(data);
        new_node.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if (this.head == null) {
            this.head = new_node;
        }
        else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            // Insert the new_node at last node
            last.next = new_node;
        }
    }

    // Method to print the LinkedList.
    public static void printList(LinkedList list)
    {
        Node currNode = list.head;

        System.out.print("List: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " -> ");
            // Go to next node
            currNode = currNode.next;
        }
    }

}
