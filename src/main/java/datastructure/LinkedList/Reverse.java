package datastructure.LinkedList;

import utils.LinkedListUtils;

/**
 * Reverse linked list
 * n1 -> n2 -> n3 -> n4 -> n5
 * n5 -> n4 -> n3 -> n2 -> n1
 *
 */
public class Reverse {
    //start from head. Keep references to 3 nodes(n1,n2,n3) in vars
    //reverse one link at a time.
    //Shift the references by one to the right (n2 becomes n1, n3 becomes n2, next of n3 becomes n3)
    //Make the last link of the original list as the head of the reversed list.

    public static void main(String[] args){
        LinkedList list = LinkedListUtils.createList();
        list.printList();

        // n1 -> n2 -> n3
        Node n1=list.getHead();
        Node n2=n1.next;
        Node n3=n2.next;
        n1.next=null;   //this will become the last node

        while(n3 != null){
            n2.next=n1;
            //shift references to the right
            n1=n2;
            n2=n3;
            n3=n3.next;
        }

        //at this point n3 is null
        n2.next=n1;
        list.setHead(n2);
        list.printList();
    }



}
