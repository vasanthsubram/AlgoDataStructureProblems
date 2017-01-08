package datastructure.LinkedList;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple linked list
 * Add or delete a link at the beginning of the linked list
 *
 * @author subramav
 *
 */
class LinkedList {
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
	public void insert(int d1) {
		Node node = new Node(d1);
		node.next = head;
		head = node;
	}

	// Deletes the link at the first of the list
	public Node delete() {
		Node temp = head;
		head = head.next;
		return temp;
	}

	 public static void main(String[] args) {
		 LinkedList list = createList();

		 list.printList();

		 list = createList();
		 list.delete();
		 list.printList();
	 }

	public static LinkedList createList(){
		LinkedList list = new LinkedList();

		list.insert(3);
		list.insert(5);
		list.insert(1);
		list.insert(8);
		return list;
	}

	public void printList() {
		Node currentNode = head;
		System.out.print("List: ");
		while (currentNode != null) {
			currentNode.printLink();
			currentNode = currentNode.next;
		}
		System.out.println("");
	}

}