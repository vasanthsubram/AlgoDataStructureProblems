package datastructure.stack;

/**
 * Implementing a stack with linked list
 * push() - would put the new element as head and 'next' of the new element would be the previous head.
 * pop() - would make the next element of the head as the new head. Remove and return previous head.
 * 
 * @param <T>
 */
public class StackByLinkedList<T> {
	
	@SuppressWarnings("hiding")
	private class Link<T> {
		Link<T> next;
		T data;
	}
	private Link<T> top;
	private int size=0;
	
	public void push(T obj){
		Link<T> newLink=new Link<T>();
		newLink.data=obj;
		newLink.next=top;
		top=newLink;
		size++;
	}
	
	public T pop(){
		Link<T> oldTop=top;
		T obj = top.data;
		top=top.next;
		oldTop.next=null;
		size--;
		return obj;
	}
	
	public boolean isEmpty(){
		return top==null;
	}
	
	public boolean isFull(){
		return false;
	}
	public String toString(){
		if(isEmpty()){
			return "Stack Contents [] \n";
		}
		StringBuffer buf = new StringBuffer();
		buf.append("Stack Contents [ ");
		for(Link<T> l=top;l!=null;l=l.next){
			buf.append("  ");
			buf.append(l.data);
		}
		buf.append("]  \n");
		return buf.toString();
	}
	
	public static void main(String[] args) {
		
		StackByLinkedList<Integer> stack = new StackByLinkedList<Integer>();
		System.out.println(stack);
		stack.push(1);
		System.out.println("push  1   => "+ stack);
		assert stack.size==1;
		
		stack.push(2);
		System.out.println("push  2   => " +stack);
		assert stack.size==2;
		assert(stack.top.data==2);
		assert(stack.top.next.data==1);
		
		stack.push(3);
		System.out.println("push  3   => " +stack);
		assert(stack.size==3);
		assert(stack.top.data==3);
		assert(stack.top.next.data==2);
		assert(stack.top.next.next.data==1);
	
		stack.pop();
		assert(stack.size==2);
		System.out.println("pop  => " +stack);
		
		stack.pop();
		assert(stack.size==1);
		System.out.println("pop  => " +stack);

	}
}
