package datastructure.LinkedList;

/**
 * Created by vasanthakumarsubramanian on 1/8/17.
 */
public class Node extends Object{
    public int data;

    public Node next;

    public Node(int d1) {
        data = d1;
    }

    @Override
    public boolean equals(Object d){
        if(d==null) return false;
        if(!(d instanceof Node)) return false;
        return this.data==((Node) d).data;
    }

    @Override
    public int hashCode(){
        return data;
    }
    public String toString(){
        return ""+data;
    }
    public void printLink() {
        System.out.print(data + " ");
    }
}