package datastructure.queue;

/**
 * The queue grows from 0th position and front is incremented after every enqueue
 * For dequeuing, front is incremented so the next element becomes the front
 * 
 * Only need 'front' and 'size' to keep track of the elements
 * 
 * @author chq-vasanthakumars
 *
 */
public class SimpleQueue {

    private int[] contents;
    private int front = 0;  // will go from 0 to size-1
    private int size = 0;

    // find the back and add the new value
    public void enqueue(int newVal) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        int back = (front + size) % contents.length;
        contents[back] = newVal;	//
        size++;
    }

    //return the value at the front
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int returnValue = contents[front];
        front = (front + 1) % contents.length;				
        size--;
        return returnValue;
    }

    public String toString() {
        if (isEmpty()) {
            return "Empty Queue \n";
        }

        StringBuffer buf = new StringBuffer();
        buf.append("Queue Contents \n");
        if (front + size > contents.length) {
            for (int i = front; i < contents.length; i++) {
                buf.append(contents[i]);
                buf.append("\n");
            }
            for (int i = 0; i < front; i++) {
                buf.append(contents[i]);
                buf.append("\n");
            }
        } else {
            for (int i = front; i < front + size; i++) {
                buf.append(contents[i]);
                buf.append("\n");
            }
        }
        buf.append("\n");
        return buf.toString();
    }

    public static void main(String[] args) {
        SimpleQueue queue = new SimpleQueue();
        System.out.println(queue);

        queue.enqueue(100);
        System.out.println("enqueue  " + queue);

        queue.enqueue(200);
        System.out.println("enqueue  " + queue);

        queue.enqueue(300);
        System.out.println("enqueue  " + queue);
        
        queue.enqueue(400);
        System.out.println("enqueue  " + queue);
        
        queue.enqueue(500);
        System.out.println("enqueue  " + queue);
        
        queue.dequeue();
        System.out.println("dequeue  " + queue);

        queue.enqueue(600);
        System.out.println("enqueue  " + queue);
    }
    
    public SimpleQueue() {
        contents = new int[32];
    }

    public SimpleQueue(int size) {
        contents = new int[size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == contents.length;
    }
}
