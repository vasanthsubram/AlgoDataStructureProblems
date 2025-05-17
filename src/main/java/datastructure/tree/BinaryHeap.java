package datastructure.tree;

import java.util.Arrays;

public class BinaryHeap {

    private static final int DEFAULT_CAPACITY = 100;

    private int heapSize;      // Number of elements in heap
    private int[] arr;          // The heap array

    public BinaryHeap( ) {
        this( DEFAULT_CAPACITY );
    }

    public BinaryHeap( int capacity ) {
        heapSize = 0;
        arr = new int[ capacity + 1 ];
    }

    public void insert( int x ) {
        if(isFull()) throw new RuntimeException( "overflow");

        /* Percolate up the smaller value by moving bigger value down */
        // parent = arr[p/2]
        int p = heapSize + 1;
        while(p > 1 && (x < arr[p/2])) {
            // parent moves to child's location
            arr[p] = arr[p/2];
            p=p/2;
        }
        arr[p] = x;
    }

    public Comparable deleteMin( ) {
        if( isEmpty( ) )
            return null;

        int minItem = arr[1];
        //move the last element to first position
        arr[ 1 ] = arr[heapSize];
        heapSize--;
        percolateDown( 1 );

        return minItem;
    }

    /**
     * Establish heap order property from an arbitrary
     * arrangement of items. Runs in linear time.
     */
    private void buildHeap( ) {
        for(int i = heapSize / 2; i > 0; i-- )
            percolateDown( i );
    }

//    private void percolateDown(int p) {
//        int child;
//        Comparable tmp = arr[p];
//        for (; p * 2 <= heapSize; p = child) {
//            child = p * 2;
//            if (child != heapSize && arr[child + 1].compareTo(arr[child]) < 0) {
//                child++;
//            }
//            if (arr[child].compareTo(tmp) < 0) {
//                arr[p] = arr[child];
//            }
//            else {
//                break;
//            }
//        }
//        arr[p] = tmp;
//    }


    /*
        If replaced element is greater than any of its child node in case of Min-Heap,
        swap the element with its smallest child(Min-Heap)
        Keep repeating the above step, if node reaches its correct position, STOP.
     */
    public void percolateDown(int k) {
        int smallestIdx = k;
        int lChildIdx = 2 * k;
        int rChildIdx = 2 * k+1;

        //find the smaller of the left and right child
        if (lChildIdx < heapSize && (arr[smallestIdx]> arr[lChildIdx])) {
            smallestIdx = lChildIdx;
        }
        if (rChildIdx < heapSize && (arr[smallestIdx]> arr[rChildIdx])) {
            smallestIdx = rChildIdx;
        }
        if (smallestIdx != k) {
            swap(k, smallestIdx);
            percolateDown(smallestIdx);
        }
    }



    public void percolateDown2(int k){

      int smallestNodeIdx = k;
      int leftChildIndex = 2 * k;
      int rightChildIndex = 2*k +1;

      if(leftChildIndex < heapSize && arr[smallestNodeIdx] < arr[leftChildIndex]){
          smallestNodeIdx = leftChildIndex;
      }
      if(leftChildIndex < heapSize && arr[smallestNodeIdx] < arr[rightChildIndex]){
            smallestNodeIdx = rightChildIndex;
      }

      if(smallestNodeIdx < heapSize){
            k = smallestNodeIdx;
          percolateDown2(k);
      }
    }

    public void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public boolean isEmpty( ) {
        return heapSize == 0;
    }

    public boolean isFull( ) {
        return heapSize == arr.length - 1;
    }


    public static void main( String [ ] args ) {
        int numItems = 10;
        BinaryHeap h = new BinaryHeap( numItems );

        /*
                                18
                             /       \
                          30          19
                         /  \          / \
                     100     80      50   20


                [null, 18, 30, 19, 100, 80, 50, 20, null]


         */
        h.insert(100);
        System.out.println(Arrays.toString(h.arr));
        h.insert(30);
        System.out.println(Arrays.toString(h.arr));
        h.insert(50);
        System.out.println(Arrays.toString(h.arr));
        h.insert(80);
        System.out.println(Arrays.toString(h.arr));
        h.insert(20);
        System.out.println(Arrays.toString(h.arr));
        h.insert(19);
        System.out.println(Arrays.toString(h.arr));
        h.insert(18);
        System.out.println(Arrays.toString(h.arr));
        h.insert(1);
        System.out.println(Arrays.toString(h.arr));
        h.deleteMin();
        System.out.println(Arrays.toString(h.arr));

    }
}