public class Heap {
    //Implementation of a heap data structure using an array of linked lists
    private LinkedList[] heap;
    //current size of occupied places in the heap
    private int currSize;

     /* Constructor.
     building a heap with given length.
     currSize initialized to 0.
      */
     public Heap(int heapSize){
        heap= new LinkedList[heapSize];
    }

    // gets the parent of given index in heap
    public int parent(int i){
        return (i-1)/2 ;
    }
    // Input: i: an array index
    // Output: The index in the heap of the left child of i
    // Running Time: O(1)
    public int left(int i){
        return i*2 +1;
    }

    // Input: i: an array index
    // Output: The index in the heap of the right child of i
    // Running Time: O(1)
    public int right(int i){
        return 2*i + 2;
    }
    // Input: list: a list to add to the heap
    // Output: adds list to the heap and corrects the order to keep it minimum heap by calling heapIncreaseKey()
    // Running Time:
    public void add(LinkedList list){
        heap[currSize] = list;
        if(currSize < heap.length){
            currSize += 1;
        }
        heapIncreaseKey();
    }
    public int removeRoot(){
        LinkedList.Node root = heap[0].head;
        heap[0].head = root.next;
        if(root.next == null){
            reducesize();
        }
        heapify(0);
        return root.data;
    }

    private void reducesize() {
        currSize = currSize - 1;
        heap[0] = heap[currSize];
        heapify(0);

    }

    // Input: none
    // Output: heap modified so the last value added isn't violating the heap property
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
    // Input: i: an array index
    // Output: heap modified so i isn't violating the heap property
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
        for( int i  = 0 ; i< currSize ; i++){
            System.out.print(heap[i].head.data + ", ");
        }
        System.out.println();
    }
}
