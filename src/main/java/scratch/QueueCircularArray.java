package scratch;

public class QueueCircularArray {

  private int front=0;
  private int size=0;
  private int[] a;

  public QueueCircularArray(int size){
    a = new int[size];
  }
  public void enqueue(int val){

    if(isFull()) {
      throw new RuntimeException("Queue Full");
    }
    int back = (front+size)%(a.length);
    a[back]=val;
    size++;
  }

  public int dequeue(){
    if(isEmpty()){
      throw new RuntimeException("Queue is empty");
    }
    int val = a[front];
    front = (front +1)%(a.length);
    size--;
    return val;
  }

  public boolean isFull(){
    return a.length==size;
  }
  public boolean isEmpty(){
    return size==0;
  }
}

