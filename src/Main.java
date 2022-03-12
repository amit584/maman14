import java.util.Scanner;

public class Main {
    /* requesting input from user for k sorted lists and inserting to a minimum heap
    A loop will then be executed, in which each iteration will consist of the following:
    1. Remove the root of heap to the output, and making the next node from "his" list the head of list.
        still at the root of th heap
    2. Rearrange the heap so the changes arnt violating the heap property
    - The reorganization of the heap is carried out using a separate routine - heapify()
    - When the output node was the last node in its list, the size of the haep is reduced by 1 - reduceSize() */
    public static void main(String[] args) {
        //k - number of lists, is set at the beginning and can be changed here.
        int k = 3;

        // an array to store the head nodes of the linked lists
        LinkedList[] lists = new LinkedList[k];
        int n = 0;
        for(int i = 0 ; i< k ; i++){
            Scanner sc = new Scanner(System.in);
            System.out.println("enter length for list #" + (i+1) +"/" + k);
            int len = sc.nextInt();
            n = n + len;
            System.out.println("enter numbers for list #" + (i+1) +"/" + k);
            int number = sc.nextInt();
            //make new list with the first number from input user
            lists[i] = new LinkedList(new LinkedList.Node(number));
            // for loop to add the rest of the numbers
            for(int j = 1 ; j < len  ; j++){
                number = sc.nextInt();
                lists[i].insert(number);
            }
        }

        //creating the heap
        Heap h = new Heap(k);
        // adding our lists to the heap from the array
        for(LinkedList i: lists){
            h.add(i);
        }

        System.out.println();
        // executing the routine removeRoot and printing the sorted list
        for(int i = 0 ; i < n ; i++){
            int root = h.removeRoot();
            System.out.print(root + " ");
        }

    }


}
