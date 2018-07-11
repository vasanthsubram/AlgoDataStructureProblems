package datastructure.queue;

import java.util.NoSuchElementException;

/**
 * Need front and back node and total to keep track of elements
 * new nodes are added to the back and back points to the new node
 */
public class QueueByLinkedList<T> {

	private class Node<T>{
		Node<T> next;
		T value;
		public Node(T newVal){
			value=newVal;
		}
	}
	private Node<T> front, back;

	public void enqueue(T  val){
		Node<T> n = new Node(val);
		if(front ==null){
			front = back =n;
		} else{
			back.next=n;
			back =n;
		}
	}
	
	public T dequeue(){
		if(front==null) throw new NoSuchElementException();
		T result= front.value;
		front = front.next;
		if(front==null) {
			back=null;
		}
		return result;
	}

	
	public String toString(){
		Node c = front;
		StringBuffer buf = new StringBuffer();
		
		while(c!=null){
			buf.append(c.value);
			buf.append("\n");
			c=c.next;
		}
		return buf.toString();
	}
	public static void main(String[] args) {
		QueueByLinkedList queue=new QueueByLinkedList();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		System.out.println(queue);
		queue.dequeue();
		System.out.println("first dequeue");
		System.out.println(queue);
	}
}
