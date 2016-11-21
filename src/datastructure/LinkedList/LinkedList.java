package datastructure.LinkedList;

import java.io.*;


public class LinkedList {
	Link top;
	int size;
	
	public void save() throws IOException{
		Link curr;
		FileOutputStream file = new FileOutputStream("c:\\persist.txt");
		DataOutputStream stream = new DataOutputStream(file);
		curr= top;
		while(curr != null){
			((Route)curr.getData()).saveInto(stream);
			curr = curr.getNext();
		}
		stream.close();
		file.close();
	}
	
	
	public static LinkedList readFrom(String fileName) throws IOException{
		FileInputStream file = new FileInputStream(fileName);
		DataInputStream stream = new DataInputStream(file);
		LinkedList list= new LinkedList();
		
		while(stream.read() != -1){
			Route newRoute = Route.readFrom(stream);
			list.addLast(newRoute);
		}
		stream.close();
		file.close();
		return list;
	}
	
	public void addFirst(Object newElement){
		Link newLink;
		if(this.isEmpty()){
			this.addToEmptyList(newElement);
			return;
		}
		newLink = createNewLinkFor(newElement);
		newLink.setNext(top);
		top=newLink;
		size++;
	}
	
	public void addLast(Object element){
		if(this.isEmpty()){
			this.addToEmptyList(element);
			return;
		}
		try{
		this.addAfter(getLastLink().getData(), element);
		}
		catch(Exception e){}
		
		return;
	}
	
	public void addAt(int position, Object element) throws Exception{
		
		if(top==null){
			this.addToEmptyList(element);
			return;
		}
		if(position<= 0){
			throw new Exception();
		}
		if(position==1){
			this.addFirst(element);
		}
		this.stitchForAdding(getLinkAtPosition(position-1), createNewLinkFor(element));
	}
	
	public Object getElementAt(int position) throws Exception{
		Link aLink;
		aLink = getLinkAtPosition(position);
		if(aLink != null){
			return aLink.getData();
		}
		return null;
	}
	
	public Object getElementAtFromEnd(int position) throws Exception{
		//this method iterates without using the size
		Link target, curr;
		int count=0;
		target = top;
		curr = top;
		
		while((curr=curr.getNext()) != null){
			if(count < position){
				count++;
			}else{
				target = target.getNext();
			}
		}
		return target.getNext().getData();
	}
	
	
	public void addAfter(Object element, Object newElement){
		Link curr;
		
		if(top==null){
			addToEmptyList(element);
			return;
		}
		curr=top;
		
		while(curr != null){
			if(curr.getData()==element){
				this.stitchForAdding(curr, createNewLinkFor(newElement));
				return;
			}
			curr = curr.getNext();
		}
	}
	
	
	public void delete(Object element){
		Link curr;
		curr = top;
		if(top==null)
			return;
		
		while(curr != null){
			
			if(curr.getNext().getData().equals(element))
			{
				curr.setNext(curr.getNext().getNext());
				size--;
				return;
			}
			curr = curr.getNext();
		}
	}
	
	
	
	public void deleteAll(){
		top=null;
		size=0;
		return;
	}
	
	protected Link getLinkAtPosition(int position) throws Exception{
		int targetPosition=position;
		Link curr;
		
		if(top==null){
			return null;
		}
		if(position>size || position==0){
			throw new Exception();
		}
		
		if(position==1)
			return top;
		
		curr = top;
		for(int i=2; i<=targetPosition;i++){
			curr = curr.getNext();
		}
		return curr;
	}
	
	protected Link createNewLinkFor(Object obj){
		return new Link(obj);
	}
	
	protected Link getLastLink() throws Exception{
		if(this.isEmpty())
			return null;
		return (this.getLinkAtPosition(size));
		
	}
	
	protected void stitchForAdding(Link curr, Link newLink){
		newLink.setNext(curr.getNext());
		curr.setNext(newLink);
		size++;
	}
	
	protected void addToEmptyList(Object newElement){
		top=createNewLinkFor(newElement);
		size++;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	/* Obselete
	 * 
	private void addFirst(Link newLink){
		this.addBefore(top, newLink);
	}
	
	public void addLast(Link newLink){
		Link aLink;
		
		if(this.isEmpty()){
			this.addToEmptyList(newLink);
			return;
		}
		aLink = this.getLastLink();
		this.addAfter(aLink, newLink);
		return;
	}
	
	public void addAt(int position, Link newLink) throws Exception{
		Link aLink;
		
		if(top==null){
			this.addToEmptyList(newLink);
			return;
		}
		if(position<= 0){
			throw new Exception();
		}
		if(position==1){
			this.addFirst(newLink);
		}
		aLink = this.getLinkAtPosition(position-1);
		this.addAfter(aLink, newLink);
	}
	
	public void addAfter(Link aLink, Link newLink){
		Link curr;
		
		if(top==null){
			addToEmptyList(newLink);
			return;
		}
		curr=top;
		
		while(curr != null){
			if(curr.equals(aLink)){
				this.stitchForAdding(curr, newLink);
				return;
			}
			curr = curr.getNext();
		}
	}
	
	public void addBefore(Link aLink, Link newLink){
		Link curr;
		
		if(top==null){
			this.addToEmptyList(newLink);
			return;
		}
		if(top==aLink){
			newLink.setNext(top);
			top=newLink;
			size++;
			return;
		}
		curr=top;
		
		while(curr != null){
			if(curr.getNext()==aLink){
				this.stitchForAdding(curr, newLink);
				return;
			}
			curr = curr.getNext();
		}
	}
	
	public void delete(Link aLink){
		Link curr;
		curr = top;
		if(top==null)
			return;
		
		while(curr != null){
			if(curr.getNext().equals(aLink))
			{
				curr.setNext(aLink.getNext());
				size--;
				return;
			}
			curr = curr.getNext();
		}
	}
	
	*/
	
	
}
