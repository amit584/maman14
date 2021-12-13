class HeapTest {
    public static void main(String[] args) {
        int k = 4;    // total number of linked lists

        // an array to store the head nodes of the linked lists
        LinkedList[] lists = new LinkedList[k];


        lists[0] = new LinkedList(new LinkedList.Node(1));
        lists[0].insert(5);

        lists[1] = new LinkedList(new LinkedList.Node(10));
        lists[1].insert(12);
        lists[1].insert(13);

        lists[2] = new LinkedList(new LinkedList.Node(2));
        lists[2].insert(6);
        lists[2].insert(7);
        lists[2].insert(11);

        lists[3] = new LinkedList(new LinkedList.Node(9));
        lists[3].insert(15);
        lists[3].insert(17);

        Heap h = new Heap(k);
        for(LinkedList i: lists){
            h.add(i);
        }
        h.printHeap();

        int root = h.removeRoot();
        h.printHeap();
    }
}
