import java.util.Arrays;
public class Heap {
    //Implementation of a heap data structure using an array
    private LinkedList[] heap;
    //current size of occupied cells in the heap
    private int currSize;

     /* Constructor.
     building a heap with given length.
     currSize initialized to 0.
      */
     public Heap(int heapSize){
        heap= new LinkedList[heapSize];
    }
    /* Constructor.
     building a heap from a given array.
     currSize initialized to array length.
     */

    // gets the parent of given index in heap
    public int parent(int i){
        return (i-1)/2 ;
    }
    // gets the left child of given index in heap
    public int left(int i){
        return i*2 +1;
    }

    // Input: i: an array index
    // Output: The index in A of the right child of i
    // Running Time: O(1)
    public int right(int i){
        return 2*i + 2;
    }

    //adds new value to the heap and corrects the order to keep it minimum heap by calling heapIncreaseKey()
    public void add(LinkedList list){
        heap[currSize] = list;
        if(currSize < heap.length){
            currSize += 1;
        }
        heapIncreaseKey();
    }
    public int removeRoot(){
        LinkedList.Node root = heap[0].head;
        heap[0].head = heap[0].head.next;
        heapify(0);
        return root.data;
    }

    // Input: none
    // Output: this.heap modified so the last value  added isn't violating the heap property
    // Running Time: O(log n) where n =heap-size[A]
    public void heapIncreaseKey(){
        int i = currSize - 1;
        while (i > 0 && heap[parent(i)].head.data > heap[i].head.data){
            LinkedList temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = parent(i);
        }
    }
    public LinkedList[] getHeap(){
        LinkedList[] b = Arrays.copyOf(heap,heap.length);
        System.out.println("in getHeap:");
        for (LinkedList num : b) {
            System.out.print(num);
        }
        return b;
    }
    // Input: i: an array index
    // Output: this.heap modified so i isn't violating the heap property
    // Running Time: O(log n) where n = heap-size[A] − i
    public void heapify(int i){
        int l = left(i);
        int r = right(i);
        int min;
        if (l < currSize && heap[l].head.data < heap[i].head.data){
            min = l;
        } else {
            min = i;
        }
        if(r < currSize && heap[r].head.data < heap[min].head.data){
            min = r;
        }
        if (min != i){
            LinkedList temp = heap[i];
            heap[i] = heap[min];
            heap[min] = temp;
            heapify(min);
        }
    }
    public void printHeap(){
        for(LinkedList i: heap){
            System.out.print(i.head.data + ",");
        }
        System.out.println();
    }
}
