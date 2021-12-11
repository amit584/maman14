class HeapTest {
    int[] a = {10,6,7,8};
    int[] b = {};
    int[] c = {10,6,7,8};
    void heapify() {
        System.out.println("only head is bad:");
        Heap h = new Heap(a);
        h.heapify(0);
        h.printHeap();
        System.out.println("empty:");
        h = new Heap(b);
        h.heapify(0);
        h.printHeap();
        System.out.println("middle index:");
        h = new Heap(c);
        h.heapify(2);
        h.printHeap();
    }
    void add(){
        final int k = 3;
        int[][] a = {{3,6,7},{1,2,4,10},{10,6,7,8}};
        Heap heap = new Heap(k);
        for ( int i = 0; i < k ; i++){
            heap.add(a[i][0]);
            heap.printHeap();
        }
    }
    public static void main(String[] args) {
        HeapTest t = new HeapTest();
        System.out.println("test heapify:");
        t.heapify();
        t = new HeapTest();
        System.out.println("\ntest add:");
        t.add();
    }
}
