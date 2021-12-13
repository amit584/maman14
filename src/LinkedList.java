public class LinkedList {
    Node head; // head of list

    // Linked list Node.
    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public LinkedList(Node n){
        head = n;
    }

    // insert new node
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
            // Insert the new_node at last node
            last.next = new_node;
        }
    }

    // Method to print the LinkedList.
    public static void printList(LinkedList list)
    {
        Node currNode = list.head;

        System.out.print("List: ");

        // go through the LinkedList
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
    }

}
