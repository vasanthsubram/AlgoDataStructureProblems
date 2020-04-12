package scratch;

public class Stack {

  private int[] a;
  private int top = -1;

  public Stack(int size){
    a = new int[size];
  }

  public boolean isEmpty(){
    return top < 0;
  }

  public void push(int val){
    if(top==a.length-1){
      throw new RuntimeException("Stack is Full");
    }
    top++;
    a[top] = val;
  }

  public int pop(){
    if(top<0){
      throw new RuntimeException("Stack is empty");
    }
    int val = a[top];
    top--;
    return val;
  }

  public static void main(String args[]){
    Stack s = new Stack(3);
    s.push(1);
    s.push(2);
    s.push(3);
    try {
      s.push(4);
    } catch (Exception e){
      System.out.println(e.getMessage());
    }

    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
    try {
      s.pop();
    } catch (Exception e){
      System.out.println(e.getMessage());
    }

  }

}
