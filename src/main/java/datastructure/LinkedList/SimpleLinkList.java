package datastructure.LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple linked list
 * Add or delete a link at the beginning of the linked list
 *
 * @author subramav
 *
 */
class SimpleLinkList {
	private Link head;

	public SimpleLinkList() {
		head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	// Inserts a new Link at the first of the list
	public void insert(int d1) {
		Link link = new Link(d1);
		link.next = head;
		head = link;
	}

	// Deletes the link at the first of the list
	public Link delete() {
		Link temp = head;
		head = head.next;
		return temp;
	}

	//reverse one link at a time
	//start from left. Keep references to 3 nodes(n1,n2,n3) in vars
	//reverse one link. Shift the references by one to the right (n2 becomes n1, n3 becomes, next of n3 becomes n3)
	public void reverse(){
		Link n1=head,n2,n3;
		n2=n1.next;
		n3=n2.next;
		n1.next=null;
		
		do{
			//reverse
			n2.next=n1;
			//shift references to the right
			n1=n2;
			n2=n3;
		} while((n3=n3.next) != null);
		
		//at this point n3 is null
		n2.next=n1;
		head=n2;
	}

	boolean hasCycle() {
		if(head==null) return false;
		if(head.next==null) return false;
		Link current=head;
		List visited=new ArrayList<Link>();

		while(current!=null){
			if(visited.contains(current)){
				return true;
			}
			visited.add(current);
			current=current.next;
		}
		return false;
	}

	public void printList() {
		Link currentLink = head;
		System.out.print("List: ");
		while (currentLink != null) {
			currentLink.printLink();
			currentLink = currentLink.next;
		}
		System.out.println("");
	}


	 static class Link {
		public int data;
		
		public Link next;

		public Link(int d1) {
			data = d1;
		}

		public void printLink() {
			System.out.print(data + " ");
		}
	}
	 
	 public static void main(String[] args) {
		 SimpleLinkList list = createList();

		 System.out.println("head = " + list.head.data);
			list.printList();
			list.reverse();
			list.printList();
			list.reverse();
			list.printList();

			while (!list.isEmpty()) {
				SimpleLinkList.Link deletedLink = list.delete();
				System.out.print("deleted: ");
				deletedLink.printLink();
				System.out.println("");
			}
			list.printList();

		 list = createList();

		 System.out.println(list.hasCycle());

		 Link current=list.head;
		 while(current!=null){
			 if(current.next!=null) {
				 current = current.next;
			 } else{
				 break;
			 }
		 }
		 current.next=list.head;

		 System.out.println(list.hasCycle());


	 }

	private static SimpleLinkList createList(){
		SimpleLinkList list = new SimpleLinkList();

		list.insert(3);
		list.insert(5);
		list.insert(1);
		list.insert(8);
		return list;
	}


}