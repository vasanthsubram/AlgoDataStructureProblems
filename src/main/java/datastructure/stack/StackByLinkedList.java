package datastructure.stack;

import java.util.EmptyStackException;

/**
 * Implementing a stack with linked list
 * push() - would put the new element as head and 'next' of the new element would be the previous head.
 * pop() - would make the next element of the head as the new head. Remove and return previous head.
 * 
 * @param <T>
 */
public class StackByLinkedList<T> {
	
	@SuppressWarnings("hiding")
	private class Node<T> {
		Node<T> next;
		T data;

		public Node(T data) {
			this.data = data;
		}
	}
	private Node<T> top;

	public void push(T obj){
		Node<T> n=new Node<T>(obj);
		n.next=top;
		top=n;
	}
	
	public T pop(){
		if(top==null) throw new EmptyStackException();
		T obj = top.data;
		top=top.next;
		return obj;
	}

	public T peek(){
		if(top==null) throw new EmptyStackException();
		return top.data;
	}

	public boolean isEmpty(){
		return top==null;
	}

	public String toString(){
		if(isEmpty()){
			return "Stack Contents [] \n";
		}
		StringBuffer buf = new StringBuffer();
		buf.append("Stack Contents [ ");
		for(Node<T> l = top; l!=null; l=l.next){
			buf.append("  ");
			buf.append(l.data);
		}
		buf.append("]  \n");
		return buf.toString();
	}
	
	public static void main(String[] args) {
		
		StackByLinkedList<Integer> stack = new StackByLinkedList<Integer>();
		System.out.println(stack);
		stack.push(4);
		System.out.println("push  4   => "+ stack);

		stack.push(2);
		System.out.println("push  2   => " +stack);
		assert(stack.top.data==2);
		assert(stack.top.next.data==1);
		
		stack.push(3);
		System.out.println("push  3   => " +stack);
		assert(stack.top.data==3);
		assert(stack.top.next.data==2);
		assert(stack.top.next.next.data==1);

		System.out.println("pop");
		System.out.println(stack.pop());
		System.out.println("pop  => " +stack);

		System.out.println("pop");
		System.out.println(stack.pop());
		System.out.println("pop  => " +stack);

	}
}
