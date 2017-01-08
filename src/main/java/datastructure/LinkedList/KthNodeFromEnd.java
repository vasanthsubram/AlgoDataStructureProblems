package datastructure.LinkedList;

/**
 * Created by vasanthakumarsubramanian on 1/8/17.
 */
public class KthNodeFromEnd {

    public static void main(String[] args) {
        LinkedList list = createList();

        Node p1 = list.getHead();
        Node p2 = list.getHead();

        int k=2;

       for(int i=0;i<k;i++){
           if(p1.next!=null) {
               p1 = p1.next;
           } else{
               System.out.println("There are not enough elements");
               return;
           }
        }

        while(p1!=null){
            p1=p1.next;
            p2=p2.next;
        }

        System.out.println("k the element is " + p2.data);

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
