package datastructure.queue;

/**
 * Need head and tail node and total to keep track of elements
 * Initially head and tail point to the same node. 
 * new nodes are added to the tail and tail points to the new node
 */
public class QueueByLinkedList {

	private Node head, tail;
	int total=0;
	
	public void enqueue(int  newVal){
		Node newNode = new Node(newVal);
		if(total==0){
			head=newNode;
			tail=newNode;
		} else{
			tail.next=newNode;
			tail=newNode;
		}
		total++;
	}
	
	public Node dequeue(){
		Node result=head;
		head=head.next;
		return result;
	}
	private class Node{
		Node next;
		int value;
		public Node(int newVal){
			value=newVal;
		}
	}
	
	public String toString(){
		Node c = head;
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
