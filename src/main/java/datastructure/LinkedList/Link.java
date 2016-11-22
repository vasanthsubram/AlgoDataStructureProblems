package datastructure.LinkedList;

public class Link<T> {

	static private int ID_COUNT=1;
	
	private Link<T> next, previous;
	private T data;
	private int id;
	
	public Link(){
		id = ID_COUNT++;
	}
	
	public Link(T newData){
		data = newData;
		id=ID_COUNT++;
	}
	
	public void setNext(Link<T> nextLink){
		next = nextLink;
	}
	
	public Link<T> getNext(){
		return this.next;
	}
	
	public void setPrevious(Link<T> nextLink){
		previous = nextLink;
	}
	
	public Link<T> getPrevious(){
		return previous;
	}
	
	public T getData(){
		return data;
	}
	
	public void setData(T newData){
		data = newData;
	}
}
