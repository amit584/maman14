import java.util.Arrays;

public class Heap {
    private int[] heap;
    private int size;

    public Heap(int size){
        this.heap= new int[size];
    }

    public Heap(int[] a){
        this.heap = a;
        this.size = a.length;
    }

    public int parent(int i){
        return i/2;
    }

    public int left(int i){
        return i*2 +1;
    }

    public int right(int i){
        return 2*i + 2;
    }

    public void add(int num){
        this.heap[size] = num;
        if(this.size < this.heap.length){
            this.size += 1;
        }
        heapIncreaseKey();
    }

    public void heapIncreaseKey(){
        int i = this.size - 1;
        while (i > 0 && this.heap[parent(i)] > this.heap[i]){
            int temp = this.heap[i];
            this.heap[i] = this.heap[parent(i)];
            this.heap[parent(i)] = temp;
            i = parent(i);
        }
    }
    public int[] getHeap(){
        int b[] = Arrays.copyOf(this.heap,this.heap.length);
        System.out.println("in getHeap:");
        for (int num : b) {
            System.out.print(num);
        }
        return b;
    }
    public void heapify(int index){
        int l = left(index);
        int r = right(index);
        int min = 0;
        if (l<this.size && this.heap[l] < this.heap[index]){
            min = l;
        } else {
            min = index;
        }
        if(r<this.size && this.heap[r] < this.heap[min]){
            min = r;
        }
        if (min != index){
            int temp = this.heap[index];
            this.heap[index] = this.heap[min];
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
