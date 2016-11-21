package datastructure.queue;

import datastructure.stack.Stack;

/**
 * Implementing queue with stacks
 *
 * Keep two stacks - one primary and another scratch
 * To enqueue, simply push into primary
 * To dequeue,
 *      pop all elements from primary into scratch
 *      pop from scratch - this is the return value for dequeue operation
 *      now push all elements from scratch back into primary
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
		return primary.isEmpty();
	}
	
	public void enqueue(T obj){
		primary.push(obj);
	}
	
	public T dequeue(){
		if(primary.isEmpty()){
			throw new QueueEmptyException();
		}
		while(!primary.isEmpty()){
			scratch.push(primary.pop());
		}
		T val= scratch.pop();
		while(!scratch.isEmpty()){
			primary.push(scratch.pop());
		}
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
			System.out.println(q.primary);
		}
		
		System.out.println(qOut);
	}
}
