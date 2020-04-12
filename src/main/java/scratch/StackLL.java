package scratch;

public class StackLL {

  Node top;

  public void push(int val){
    Node n = new Node(val);
    n.next=top;
    top=n;
  }

  public int pop(){
    if(top==null){
      throw new RuntimeException("Stack is empty");
    }
    int val = top.value;
    top = top.next;
    return  val;
  }

  static class Node{
      Node next;
      int value;

    public Node(int v){
      value = v;
    }
  }

  public static void main(String[] args){

    StackLL stack = new StackLL();
    stack.push(1);
    stack.push(2);
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    try{
      stack.pop();
    } catch (Exception e){
      System.out.println(e.getMessage());
    }
  }

}

