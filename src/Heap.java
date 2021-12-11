import java.util.Arrays;
public class Heap {
    //Implementation of a heap data structure using an array
    private int[] heap;
    //current size of occupied cells in the heap
    private int currSize;

     /* Constructor.
     building a heap with given length.
     currSize initialized to 0.
      */
        public Heap(int heapSize){
        this.heap= new int[heapSize];
    }
    /* Constructor.
     building a heap from a given array.
     currSize initialized to array length.
     */
    public Heap(int[] a){
        this.heap = a;
        this.currSize = a.length;
    }

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
    public void add(int num){
        this.heap[currSize] = num;
        if(this.currSize < this.heap.length){
            this.currSize += 1;
        }
        heapIncreaseKey();
    }

    // Input: none
    // Output: this.heap modified so the last value  added isn't violating the heap property
    // Running Time: O(log n) where n =heap-size[A]
    public void heapIncreaseKey(){
        int i = this.currSize - 1;
        while (i > 0 && this.heap[parent(i)] > this.heap[i]){
            int temp = this.heap[i];
            this.heap[i] = this.heap[parent(i)];
            this.heap[parent(i)] = temp;
            i = parent(i);
        }
    }
    public int[] getHeap(){
        int[] b = Arrays.copyOf(this.heap,this.heap.length);
        System.out.println("in getHeap:");
        for (int num : b) {
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
        if (l<this.currSize && this.heap[l] < this.heap[i]){
            min = l;
        } else {
            min = i;
        }
        if(r<this.currSize && this.heap[r] < this.heap[min]){
            min = r;
        }
        if (min != i){
            int temp = this.heap[i];
            this.heap[i] = this.heap[min];
            this.heap[min] = temp;
            this.heapify(min);
        }
    }
    public void printHeap(){
        for(int i: this.heap){
            System.out.print(i+",");
        }
        System.out.println();
    }
}
