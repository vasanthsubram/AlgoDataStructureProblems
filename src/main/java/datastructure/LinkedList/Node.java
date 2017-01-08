package datastructure.LinkedList;

/**
 * Created by vasanthakumarsubramanian on 1/8/17.
 */
public class Node {
    public int data;

    public Node next;

    public Node(int d1) {
        data = d1;
    }

    public void printLink() {
        System.out.print(data + " ");
    }
}