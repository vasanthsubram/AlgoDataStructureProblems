package scratch;

import datastructure.LinkedList.LinkedList;
import datastructure.LinkedList.Node;
import utils.LinkedListUtils;

public class Reverse {

  public static void main(String[] args) {
    LinkedList list = LinkedListUtils.createList();
    list.printList();

    Node n1 = list.getHead();
    Node n2 = n1.next;
    Node n3 = n2.next;

    n1.next=null;

    while(n3!=null) {
      n2.next = n1;

      n1 = n2;
      n2 = n3;
      n3 = n3.next;
    }

    //at this point n3= null
    n2.next=n1;
    list.setHead(n2);
    list.printList();;
  }
}
