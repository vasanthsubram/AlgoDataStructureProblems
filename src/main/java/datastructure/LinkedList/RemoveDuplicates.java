package datastructure.LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Created by vasanthakumarsubramanian on 1/8/17.
 */
public class RemoveDuplicates {

    public static void main(String[] args){
        removeDuplicates_WithBuffer();
        removeDuplicates_WithoutBuffer();
    }

    //O(n), space - O(N)
    private static void removeDuplicates_WithBuffer(){
        LinkedList list = createListWithDuplicates();
        list.printList();  //8 8 1 5 5 3 3

        Node n = list.getHead();
        Node prev = n;
        Set<Node> visited = new HashSet<>();

        while(n!=null){
            if(visited.contains(n)){
                if(n.next==null){
                    prev.next=null;
                } else {
                    prev.next = n.next;
                }
            } else {
                visited.add(n);
            }
            prev=n;
            n=n.next;
        }
        list.printList();;
    }

    //O(n^2) , space O(1)
    public static void removeDuplicates_WithoutBuffer() {

        LinkedList list = createListWithDuplicates();
        list.printList();

        Node n = list.getHead();
        Node runner;

        while(n !=null && (n.next != null)){
            runner=n;
            while(runner != null && (runner.next!=null)) {
                if (n.data == runner.next.data) {
                    runner.next = runner.next.next;
                }
                runner=runner.next;
            }
            n=n.next;
        }
        list.printList();
    }

    private static LinkedList createListWithDuplicates(){
        LinkedList list = new LinkedList();
        list.insert(3);
        list.insert(3);
        list.insert(5);
        list.insert(5);
        list.insert(1);
        list.insert(8);
        list.insert(8);
        return list;
    }
}
