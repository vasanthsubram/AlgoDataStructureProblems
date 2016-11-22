package datastructure.stack;

public class SimpleStack {

	private int[] contents;
	private int top=-1;
 
	public SimpleStack(){
		contents = new int[32];
	}
	
	public SimpleStack(int size){
		contents = new int[size];
	}
	
	public boolean isEmpty(){
		return top==-1;
	}
	
	public boolean isFull(){
		return top==contents.length-1;
	}
	
	public void push(int newElement){
		if(isFull()){
			throw new StackFullException("SimpleStack full");
		}
		top++;
		contents[top]=newElement;
		
	}
	
	public int pop() {
		if(isEmpty()){
			throw new EmptyStackException("Simple stack is empty");
		}
		int val = contents[top];
		top--;
		return val;
		
	}
	
	public String toString(){
		if(isEmpty()){
			return "Empty Stack \n";
		}
		StringBuffer buf = new StringBuffer();
		buf.append("Stack Contents \n");
		for(int i=top;i>=0;i--){
			buf.append(contents[i]);
			buf.append("\n");
		}
		buf.append("\n");
		return buf.toString();
	}
	
	public static void main(String[] args) {
		SimpleStack stack = new SimpleStack();
		System.out.println(stack);
		
		stack.push(3);
		System.out.println("push  "+ stack);
		
		stack.push(30);
		System.out.println("push  " +stack);
		
		stack.push(300);
		System.out.println("push  " +stack);
		
		stack.pop();
		System.out.println("pop  " +stack);
		

	}

}
