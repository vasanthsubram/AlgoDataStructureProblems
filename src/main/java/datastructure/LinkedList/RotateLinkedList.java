package datastructure.LinkedList;

/*
Rotate the linked list by “k”th element’s in clockwise in a given linked list.

Input:- 10->20->30->40->50->60 and input k = 3
Output:- 40->50->60->10->20->30


Input:- 10->20->30->40->50->60 and input k = 4
Output:- 50->60->10->20->30->40
 */

public class RotateLinkedList {
    public static void main(String[] args){
        int k_node=3;
        rotate(k_node);

        System.out.println();
        k_node=4;
        rotate(k_node);
    }

    private static void rotate(int k_node){
        LinkedList linkedList = createList();
        linkedList.printList();
        Node originalHead = linkedList.getHead();

        //find the kth node
        Node k_Node = k_thNode(k_node,linkedList);

        //make the k+1 element the new head
        Node newHead= k_Node.next;

        //make the next-of kth element null
        k_Node.next=null;

        //connect the last element to list's original head
        Node lastNode=lastNode(newHead);
        lastNode.next=originalHead;

        linkedList.setHead(newHead);
        linkedList.printList();
    }

    private static Node lastNode(Node k_node){
        if(k_node==null) return k_node;
        while(k_node.next !=null){
            k_node=k_node.next;
        }
        return k_node;
    }

    private static Node k_thNode(int k, LinkedList linkedList){
        Node n=linkedList.getHead();
        for(int i=1;i<k;i++){
            n = n.next;
            if(n==null) throw new RuntimeException("Not enough element");
        }
        return n;
    }

    public static LinkedList createList(){
        LinkedList list = new LinkedList();
        list.insert(60);
        list.insert(50);
        list.insert(40);
        list.insert(30);
        list.insert(20);
        list.insert(10);
        return list;
    }
}
