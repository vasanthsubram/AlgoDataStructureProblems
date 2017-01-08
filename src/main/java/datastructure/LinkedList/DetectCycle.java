package datastructure.LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vasanthakumarsubramanian on 1/8/17.
 */
public class DetectCycle {

    public static void main(String[] args) {
        LinkedList list = LinkedList.createList();
        list.printList();
        detectCycle(list);

        createCycle(list);

        detectCycle(list);

    }

    private static void detectCycle(LinkedList list){
        if(list.getHead()==null || (list.getHead().next==null)){
            System.out.println("No cycle");
        }

        Node current=list.getHead();
        List visited=new ArrayList<Node>();

        while(current!=null){
            if(visited.contains(current)){
                System.out.println("Contains cycle");
                return;
            }
            visited.add(current);
            current=current.next;
        }
        System.out.println("No cycle");
    }

    private static void createCycle(LinkedList list){
        Node current=list.getHead();
        while(current!=null){
            if(current.next!=null) {
                current = current.next;
            } else{
                break;
            }
        }
        current.next=list.getHead();
    }
}
