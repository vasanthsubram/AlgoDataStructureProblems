package datastructure.LinkedList;

import utils.LinkedListUtils;

/**
 * Simple linked list
 *
 * @author subramav
 *
 */
public class LinkedList {
	private Node head;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public LinkedList() {
		head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	// Inserts a new Node at the first of the list
	public void insert(int t) {
		Node node = new Node(t);
		node.next = head;
		head = node;
	}

	// Deletes the link at the first of the list
	public Node delete() {
		Node temp = head;
		head = head.next;
		return temp;
	}


	public void delete(int t) {
		Node node = head, prev=head;

		if(head==null) return;

		//if the head is the node to delete
		if(node.data==t){
			head=head.next;
			return;
		}

		while(node!=null) {
			if(node.data==t){
				prev.next=node.next;
				return;
			}
			prev=node;
			node=node.next;
		}
	}

	 public static void main(String[] args) {
		 LinkedList list = LinkedListUtils.createList();
		 list.printList();
		 list.delete(8);
		 list.printList();
		 list.delete(1);
		 list.printList();
		 list.delete(9);
		 list.printList();
		 list.delete(3);
		 list.printList();
		 list.delete(5);
		 list.printList();
	 }


	public void printList() {
		Node node = head;
		System.out.print("List: ");
		while (node != null) {
			node.printLink();
			node = node.next;
		}
		System.out.println("");
	}



}