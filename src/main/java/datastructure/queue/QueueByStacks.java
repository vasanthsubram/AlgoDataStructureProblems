package datastructure.queue;

import datastructure.stack.Stack;

/**
 * Implementing queue with stacks
 *
 * Keep two stacks - one primary and another scratch
 * To enqueue, simply push into primary
 * To dequeue,
 *     if scratch is not empty, pop from it
 *     If scratch is empty, pop all from primary and push them into scratch. Then pop from scratch\
 *
 * @author vsubramanian
 * @param <T>
 */
public class QueueByStacks<T> {

	private Stack<T> primary ,scratch;

	public QueueByStacks(Class<T> clazz){
		primary= new Stack<T>(clazz);
		scratch= new Stack<T>(clazz);
	}
	
	public boolean isEmpty(){
		return primary.isEmpty() && scratch.isEmpty();
	}
	
	public void enqueue(T obj){
		primary.push(obj);
	}

	public T dequeue(){
		if(!scratch.isEmpty()){
			return scratch.pop();
		}
		if(primary.isEmpty()){
			throw new RuntimeException("Queue Empty");
		}
		while(!primary.isEmpty()){
			scratch.push(primary.pop());
		}
		T val= scratch.pop();

		return val;
	}
	
	
	public static void main(String[] args) {	
		QueueByStacks<String> q = new QueueByStacks<String>(String.class);
		q.enqueue("Plane");
		q.enqueue(" Landed");
		q.enqueue(" on");
		q.enqueue(" hudson");
		
		System.out.println(q.primary);
		String qOut="";
		while(!q.isEmpty()){
			qOut=qOut+q.dequeue()+" ";
//			System.out.println(q.primary);
		}
		
		System.out.println(qOut);
	}
}
