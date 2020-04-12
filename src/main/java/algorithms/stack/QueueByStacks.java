package algorithms.stack;
import java.util.Stack;
/**
 * Created by vasanth on 11/26/16.
 */
public class QueueByStacks<T> {
        Stack<T> stack = new Stack<T>();
        Stack<T> stackQueue = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
            stack.push(value);
        }

        public T peek() {
            return peekOrDequeue("peek");
        }

        public T dequeue() {
            return peekOrDequeue("dequeue");
        }

        private T peekOrDequeue(String flag){
            if(stackQueue.isEmpty()){
                repopulateStackQueue();
            }
            T value=null;
            if(!stackQueue.isEmpty()){
                if(flag.equals("peek")){
                    value=stackQueue.peek();
                } else{
                    value=stackQueue.pop();
                }
            }
            return value;

        }
        private void repopulateStackQueue(){
            while(!stack.isEmpty()){
                stackQueue.push(stack.pop());
            }
    }

    public static void main(String[] args) {
        QueueByStacks<Integer> queue = new QueueByStacks<Integer>();
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.peek());
        queue.enqueue(6);
        queue.enqueue(7);
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
    }
}