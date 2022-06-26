# an assignment for the Data structures course
this program will merge linked lists from user input using a minimum heap.
The input to the program will be k series of numbers, each of which is sorted in descending order.
The output will be a single sorted series.
the stages of the program:
1. requesting input from user for k sorted lists 
2. inserting the lists to a minimum heap
3. A loop in which each iteration will consist of the following:
    1. Remove the root of heap to the output, and making the next node from "his" list the head of list.
        still at the root of the heap.
    2. Rearrange the heap so the changes arn't violating the heap property
    - The reorganization of the heap is carried out using a separate routine - heapify()
    - When the output node was the last node in its list, the size of the haep is reduced by 1 - reduceSize() 

time complexity - main class of the program:
1. O(n) exepting and building k lists with n numbers overall
2. O(log k) adding k lists to the heap using add function.
3. n * O(log k)  = O(n*log k) for removing the root and fixing the heap for all n numbers.

overall: O(n) + O(log k) + O(n*log k) = O(n*log k)
