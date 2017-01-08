package datastructure.LinkedList;

/**
 * Created by vasanthakumarsubramanian on 1/8/17.
 */
public class Reverse {

    //reverse one link at a time
    //start from left. Keep references to 3 nodes(n1,n2,n3) in vars
    //reverse one link. Shift the references by one to the right (n2 becomes n1, n3 becomes, next of n3 becomes n3)
    public static void main(String[] args){
        LinkedList list = createList();
        list.printList();
        Node n1=list.getHead(),n2,n3;
        n2=n1.next;
        n3=n2.next;
        n1.next=null;

        do{
            //reverse
            n2.next=n1;
            //shift references to the right
            n1=n2;
            n2=n3;
        } while((n3=n3.next) != null);

        //at this point n3 is null
        n2.next=n1;
        list.setHead(n2);
        list.printList();

    }

    private static LinkedList createList(){
        LinkedList list = new LinkedList();
        list.insert(3);
        list.insert(5);
        list.insert(1);
        list.insert(18);
        list.insert(8);
        return list;
    }

}
