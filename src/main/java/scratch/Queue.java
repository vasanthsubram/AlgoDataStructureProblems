package scratch;

public class Queue {

  private Stack primary = new Stack(10);
  private Stack secondary = new Stack(10);

  public void enqueue(int v){
    primary.push(v);
  }

  public int dequeue(){
    if(!secondary.isEmpty()){
      return secondary.pop();
    }
    if(primary.isEmpty()){
      throw new RuntimeException("Queue is empty");
    }
    while(!primary.isEmpty()){
      int val = primary.pop();
      secondary.push(val);
    }
    return secondary.pop();
  }

  public static void main(String[] args){
    Queue q = new Queue();
    q.enqueue(1);
    q.enqueue(2);
    System.out.println(q.dequeue());
    q.enqueue(3);
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
  }
}
