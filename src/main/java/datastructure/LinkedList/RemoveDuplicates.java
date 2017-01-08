package datastructure.LinkedList;

/**
 * uses no buffer but is N-squared.
 *
 * Created by vasanthakumarsubramanian on 1/8/17.
 */
public class RemoveDuplicates {

    public static void main(String[] args) {

        LinkedList list = createListWithDuplicates();
        list.printList();

        Node current = list.getHead();
        Node runner;

        while(current !=null && (current.next != null)){
            runner=current;
            while(runner != null && (runner.next!=null)) {
                if (current.data == runner.next.data) {
                    if(runner.next.next!=null) {
                        runner.next = runner.next.next;
                    }else{
                        runner.next=null;
                    }
                }
                runner=runner.next;
            }
            current=current.next;
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
