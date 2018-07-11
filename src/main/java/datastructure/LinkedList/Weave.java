package datastructure.LinkedList;

import utils.*;

/*
    Given             a1 ->a2 -> ••• - >an ->b1 ->b2 -> ••• ->bn
    rearrange it into a1 ->b1 ->a2 ->b2 -> ... ->an ->bn
 */
public class Weave {

    public static void main(String[] args){
        LinkedList list = LinkedListUtils.createList();
        list.printList(); //22 8 18 1 5 3  ->  22 1 8 5 18 3
        Node p1=list.getHead().next;
        Node p2=list.getHead();

        while(p1.next!=null){
            p2=p2.next;
            p1=p1.next.next;
        }
        p1=list.getHead();
        p2=p2.next;
        while(p2!=null){
            Node p1Next=p1.next;
            Node p2Next=p2.next;

            p1.next = p2;
            if(p2Next!=null) {
                p2.next = p1Next;
            }
            p1=p1Next;
            p2=p2Next;
        }
        list.printList();
    }
}
