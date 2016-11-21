package datastructure.stack;

import java.lang.reflect.Array;

public class Stack<T> {

	private T[] contents;
	private int top=-1;
 
	@SuppressWarnings("unchecked")
	public Stack(Class<T> clazz){
		contents = (T[]) Array.newInstance(clazz, 32);
	}
	
	@SuppressWarnings("unchecked")
	public Stack(Class<T> clazz, int size){
		contents = (T[]) Array.newInstance(clazz, size);
	}
	
	public boolean isEmpty(){
		return top==-1;
	}
	
	public boolean isFull(){
		return top==contents.length-1;
	}
	
	public void push(T newElement){
		if(top==contents.length-1){
			throw new StackFullException("Stack full");
		}
		top++;
		contents[top]=newElement;
	}
	
	public T pop() {
		if(top==-1){
			throw new EmptyStackException("Stack is empty");
		}
		T val = contents[top];
		contents[top]=null;	//stop the leak
		top--;
		return val;
	}
	
	public String toString(){
		if(isEmpty()){
			return "Stack Contents [] \n";
		}
		StringBuffer buf = new StringBuffer();
		buf.append("Stack Contents [ ");
		for(int i=top;i>=0;i--){
			buf.append("  ");
			buf.append(contents[i]);
		}
		buf.append("]  \n");
		return buf.toString();
	}
	
	public static void main(String[] args) {
		
		Stack<Integer> stack0 = new Stack<Integer>(Integer.class);
		System.out.println(stack0);
		stack0.push(1);
		System.out.println("push  1   => "+ stack0);
		
		stack0.push(2);
		System.out.println("push  2   => " +stack0);

		stack0.push(3);
		System.out.println("push  3   => " +stack0);
		
		stack0.pop();
		System.out.println("pop  => " +stack0);
		stack0.pop();
		System.out.println("pop  => " +stack0);

	}
}
