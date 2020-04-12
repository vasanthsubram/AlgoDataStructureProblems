package datastructure.LinkedList;

import utils.LinkedListUtils;

/*
 * Reverse linked list
 * n1 -> n2 -> n3 -> n4 -> n5       =>     n5 -> n4 -> n3 -> n2 -> n1
 */
public class Reverse2 {
    public static void main(String[] args) {
        LinkedList list = LinkedListUtils.createList();
        list.printList();

        Node source = list.getHead();

        LinkedList reversed = new LinkedList();
        reversed.insert(source.data);
        source=source.next;

        while (source != null) {
            reversed.insert(source.data);
            source=source.next;
        }
        reversed.printList();
    }
}
