package datastructure.LinkedList;
/*
Partition: Write code to partition a linked list around a value x (pivot), such that all nodes less than x come
before all nodes greater than or equal to x. lf x is contained within the list, the values of x only need
to be after the elements less than x (see below). The partition element x can appear anywhere in the
"right partition"; it does not need to appear between the left and right partitions.

EXAMPLE
Input: 3 -> 5 -> 8 -> 5 - > 10 -> 2 -> 1 [partition = 5)
Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */

public class Partition {

    public static void main(String[] args) {
        int pivot = 5;
        //there could be multiple pivot element or no pivot element
        //all numbers < pivot should move to left partition
        //numbers greater than pivot can remain in left parition
        // order within the parition need not be maintained

        //simple case - one pivot is there
        //disconnect lesser element and put it in leftList
        LinkedList list=createList();
        list.printList();
        run(pivot,list);

        System.out.println();
        list = increasingElementList();
        list.printList();
        run(pivot,list);

        System.out.println();
        list=decreasingElementList();
        list.printList();
        run(pivot,list);

        System.out.println();
        list=sameElementList();
        list.printList();
        run(pivot,list);
    }

    private static void run(int pivot, LinkedList list){
        Node curr=list.getHead();
        Node newHead=curr, newTail=curr;

        while(curr!=null){
            Node next=curr.next;
            if(curr.data <pivot){
                //add lesser element at the head,
                curr.next=newHead;
                newHead=curr;
            } else{
                //add higher element at the tail
                newTail.next=curr;
                newTail=curr;
            }
            curr=next;
        }
        newTail.next=null;
        list.setHead(newHead);
        list.printList();
    }

    private static LinkedList createList(){
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(10);
        list.insert(5);
        list.insert(8);
        list.insert(5);
        list.insert(3);
        return list;
    }

    private static LinkedList increasingElementList(){
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(8);
        list.insert(5);
        list.insert(5);
        list.insert(4);
        list.insert(3);
        list.insert(1);
        return list;
    }

    private static LinkedList decreasingElementList(){
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(5);
        list.insert(8);
        list.insert(10);
        return list;
    }

    private static LinkedList sameElementList(){
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(1);
        list.insert(1);
        list.insert(1);
        list.insert(1);
        list.insert(1);
        list.insert(1);
        return list;
    }

    //    private void run1(int pivot, LinkedList list){
//        Node start = null, end = null;
//        Node n;
//
//        boolean rightNodeSet = false;
//
//        n = list.getHead(); //3 -> 5 -> 8 -> 5 - > 10 -> 2 -> 1
//        list.printList();
//        Node prev = n;
//
//        while (n != null) {
//            if (n.data >= pivot) {
//                if (!rightNodeSet) {
//                    list.setHead(n);  // first element that is >= pivot
//                    rightNodeSet = true;
//                }
//                prev = n;
//                n = n.next;
//            } else {
//                Node temp = n.next;
//                //move element to left
//                if (start == null) {
//                    start = end = n;
//                } else {
//                    end.next = n;
//                    end = end.next;
//                }
//                end.next = null;
//                n = temp;
//                prev.next = n;
//            }
//        }
//        if (start != null){
//            end.next = list.getHead();
//            list.setHead(start);
//        }
//        list.printList();
//    }
}
