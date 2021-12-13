import java.util.Scanner;

class HeapTest {
    public static void main(String[] args) {
        int k = 3;
        LinkedList[] lists2 = new LinkedList[k];

        lists2[0] = new LinkedList(new LinkedList.Node(3));
        lists2[0].insert(7);
        lists2[0].insert(18);
        lists2[0].insert(32);
        lists2[1] = new LinkedList(new LinkedList.Node(6));
        lists2[1].insert(27);
        lists2[1].insert(35);
        lists2[2] = new LinkedList(new LinkedList.Node(14));
        lists2[2].insert(28);
        lists2[2].insert(75);
        lists2[2].insert(96);
        lists2[2].insert(107);

        Heap h2 = new Heap(k);
        for(LinkedList i: lists2){
            h2.add(i);
        }

        for(int i = 0 ; i < 12 ; i++){
            int root = h2.removeRoot();
            System.out.print(root+", ");
        }
        System.out.println();

        k = 4;

        // an array to store the head nodes of the linked lists
        LinkedList[] lists = new LinkedList[k];

        for(int i = 0 ; i< k ; i++){
            System.out.println("enter numbers for list #" + (i+1) +"/" + k +" (-1 for next list)");
            // First get the scanner object with the input stream
            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();
            lists[i] = new LinkedList(new LinkedList.Node(number));
            number = sc.nextInt();
            while (number != -1){
                lists[i].insert(number);
                number = sc.nextInt();
            }
        }

        Heap h = new Heap(k);
        for(LinkedList i: lists){
            h.add(i);
        }

        for(int i = 0 ; i < 11 ; i++){
            int root = h.removeRoot();
            System.out.print(root+", ");
        }


    }
}
