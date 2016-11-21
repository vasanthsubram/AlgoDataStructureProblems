package datastructure.stack;

public class StackFullException extends RuntimeException{
	public StackFullException(){}
	
	public StackFullException(String message){
		super(message);
	}
}
