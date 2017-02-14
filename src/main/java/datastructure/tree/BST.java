package datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST {
	protected BSTNode root = null;

	public boolean isEmpty() {
		return root == null;
	}

	//search
	protected Comparable search(BSTNode p, Comparable el) {
		while (p != null){
			if (el.equals(p.el))
				return p.el;
			else if (el.compareTo(p.el) < 0)
				p = p.left;
			else
				p = p.right;
		}
		return null;
	}

	//insert
	public void insert(Comparable val){
		BSTNode p = root, prev=null;
		BSTNode newNode =new BSTNode(val);

		if(root==null){// tree is empty;
			root=newNode;
			return;
		}
		while(p!=null){// find a place for inserting new node;
			prev=p;
			if(p.el.compareTo(val)<0){
				p=p.right;
			} else{
				p=p.left;
			}
		}

		if(prev.el.compareTo(val)<0){
			prev.right=newNode;
		} else{
			prev.left=newNode;
		}
	}


	protected void visit(BSTNode p) {
		System.out.print(p.el + " ");
	}

	public void inorder(){
		if(root==null){
			return;
		}
		inorder(root);
	}
	private void inorder(BSTNode p) {
		if (p != null) {
			inorder(p.left);
			visit(p);
			inorder(p.right);
		}
	}

	public  void preorder(){
		if(root==null){
			return;
		}
		preorder(root);
	}
	private void preorder(BSTNode p) {
		if (p != null) {
			visit(p);
			preorder(p.left);
			preorder(p.right);
		}
	}

	public void postorder() {
		if(root==null){
			return;
		}
		postorder(root);
	}
	private void postorder(BSTNode p) {
		if (p != null) {
			postorder(p.left);
			postorder(p.right);
			visit(p);
		}
	}

	public void deleteByCopying(Comparable el) {
		BSTNode node, p = root, prev = null;
		
		if(root==null){
			System.out.println("the tree is empty");
			return;
		}
		while (p != null && !p.el.equals(el)) { // find the node p
			prev = p; // with element el;
			if (p.el.compareTo(el) < 0)
				p = p.right;
			else
				p = p.left;
		}
		
		if(!p.el.equals(el)){
			System.out.println("el " + el + " is not in the tree");
			return;
		}
		node = p;
		
		if (node.right == null) // node has no right child;
			node = node.left;
		else if (node.left == null) // no left child for node;
			node = node.right;
		else {
			BSTNode tmp = node.left; // node has both children;
			BSTNode previous = node; // 1.
			while (tmp.right != null) { // 2. find the rightmost
				previous = tmp; // position in the
				tmp = tmp.right; // left subtree of node;
			}
			node.el = tmp.el; // 3. overwrite the reference
								// of the element being deleted;
			if (previous == node) // if node's left child's
				previous.left = tmp.left; // right subtree is null;
			else
				previous.right = tmp.left; // 4.
		}
		if (p == root)
			root = node;
		else if (prev.left == p)
			prev.left = node;
		else
			prev.right = node;
	}

	public void deleteByMerging(Comparable el) {
		BSTNode tmp, node, p = root, prev = null;
		while (p != null && !p.el.equals(el)) { // find the node p
			prev = p; // with element el;
			if (p.el.compareTo(el) < 0)
				p = p.right;
			else
				p = p.left;
		}
		node = p;
		if (p != null && p.el.equals(el)) {
			if (node.right == null) // node has no right child: its left
				node = node.left; // child (if any) is attached to its parent;
			else if (node.left == null) // node has no left child: its right
				node = node.right; // child is attached to its parent;
			else { // be ready for merging subtrees;
				tmp = node.left; // 1. move left
				while (tmp.right != null)
					// 2. and then right as far as
					tmp = tmp.right; // possible;
				tmp.right = // 3. establish the link between the
				node.right; // the rightmost node of the left
							// subtree and the right subtree;
				node = node.left; // 4.
			}
			if (p == root)
				root = node;
			else if (prev.left == p)
				prev.left = node;
			else
				prev.right = node;
		} else if (root != null)
			System.out.println("el " + el + " is not in the tree");
		else
			System.out.println("the tree is empty");
	}

	public void iterativePreorder() {
		BSTNode p = root;
		if (p == null) {
			return;
		}
		Stack stack = new Stack();
		stack.push(p);

		while (!stack.isEmpty()) {
			p = (BSTNode) stack.pop();
			visit(p);
			if (p.right != null)
				stack.push(p.right);
			if (p.left != null) // left child pushed after right, to be on the top of the stack
				stack.push(p.left);
		}
	}

	public void iterativeInOrder() {
		final Stack<BSTNode> stack = new Stack();
		BSTNode p = root;

		while (!stack.isEmpty() || p != null) {
			if (p != null) {
				//push left nodes until null
				stack.push(p);
				p = p.left;
			} else {
				p = stack.pop();
				System.out.print(p.el + " ");
				p = p.right;
			}
		}
	}


	public void iterativePostorder2() {
		BSTNode p = root;
		Stack travStack = new Stack(), output = new Stack();
		if (p != null) { // left-to-right postorder = right-to-left preorder
			travStack.push(p);
			while (!travStack.isEmpty()) {
				p = (BSTNode) travStack.pop();
				output.push(p);
				if (p.left != null)
					travStack.push(p.left);
				if (p.right != null)
					travStack.push(p.right);
			}
			while (!output.isEmpty()) {
				p = (BSTNode) output.pop();
				visit(p);
			}
		}
	}


	public void iterativePostorder() {
		BSTNode p = root, visited = root;
		Stack stack = new Stack();
		while (p != null) {
			//go to left most node while pushing the nodes on the way to stack
			for (; p.left != null; p = p.left)
				stack.push(p);
			//go inside while, if p is a leaf node  (as the for loop exhausted the left node)
			//or if the last visited node is actually my right child (ie., have already visited both my children)
			while (p != null && (p.right == null || p.right == visited)) {
				visit(p);
				visited = p;
				if (stack.isEmpty())
					return;
				p = (BSTNode) stack.pop();
			}
			//there is a right node, so push myself and follow the right subtree
			stack.push(p);
			p = p.right;
		}
	}

	public void breadthFirst() {
		BSTNode p = root;
		if (p == null) {
			return;
		}
		Queue<BSTNode> queue = new LinkedList<>();
		queue.add(p);
		while (!queue.isEmpty()) {
			p = queue.remove();
			visit(p);
			if (p.left != null)
				queue.add(p.left);
			if (p.right != null)
				queue.add(p.right);
		}
	}

	public void MorrisInorder() {
		BSTNode p = root, tmp;
		while (p != null)
			if (p.left == null) {
				visit(p);
				p = p.right;
			} else {
				tmp = p.left;
				while (tmp.right != null && // go to the rightmost node of
						tmp.right != p)
					// the left subtree or
					tmp = tmp.right; // to the temporary parent of p;
				if (tmp.right == null) {// if 'true' rightmost node was
					tmp.right = p; // reached, make it a temporary
					p = p.left; // parent of the current root,
				} else { // else a temporary parent has been
					visit(p); // found; visit node p and then cut
					tmp.right = null; // the right pointer of the current
					p = p.right; // parent, whereby it ceases to be
				} // a parent;
			}
	}

	public void MorrisPreorder() {
		BSTNode p = root, tmp;
		while (p != null) {
			if (p.left == null) {
				visit(p);
				p = p.right;
			} else {
				tmp = p.left;
				while (tmp.right != null && // go to the rightmost node of
						tmp.right != p)
					// the left subtree or
					tmp = tmp.right; // to the temporary parent of p;
				if (tmp.right == null) {// if 'true' rightmost node was
					visit(p); // reached, visit the root and
					tmp.right = p; // make the rightmost node a temporary
					p = p.left; // parent of the current root,
				} else { // else a temporary parent has been
					tmp.right = null; // found; cut the right pointer of
					p = p.right; // the current parent, whereby it ceases
				} // to be a parent;
			}
		}
	}

	public void MorrisPostorder() {
		BSTNode p = new BSTNode(), tmp, q, r, s;
		p.left = root;
		while (p != null)
			if (p.left == null)
				p = p.right;
			else {
				tmp = p.left;
				while (tmp.right != null && // go to the rightmost node of
						tmp.right != p)
					// the left subtree or
					tmp = tmp.right; // to the temporary parent of p;
				if (tmp.right == null) {// if 'true' rightmost node was
					tmp.right = p; // reached, make it a temporary
					p = p.left; // parent of the current root,
				} else { // else a temporary parent has been found;
					// process nodes between p.left (included) and p (excluded)
					// extended to the right in modified tree in reverse order;
					// the first loop descends this chain of nodes and reverses
					// right pointers; the second loop goes back, visits nodes,
					// and reverses right pointers again to restore the pointers
					// to their original setting;
					for (q = p.left, r = q.right, s = r.right; r != p; q = r, r = s, s = s.right)
						r.right = q;
					for (s = q.right; q != p.left; q.right = r, r = q, q = s, s = s.right)
						visit(q);
					visit(p.left); // visit node p.left and then cut
					tmp.right = null; // the right pointer of the current
					p = p.right; // parent, whereby it ceases to be
				} // a parent;
			}
	}

	public void balance(Comparable data[], int first, int last) {
		if (first <= last) {
			int middle = (first + last) / 2;
			insert(data[middle]);
			balance(data, first, middle - 1);
			balance(data, middle + 1, last);
		}
	}

	public void print(){
		inorder(root);
	}
	
	String tabs(int num){
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<num;i++){
			sb.append("\t");
		}
		return sb.toString();
	}

	//height of node under the given node
	public int height(BSTNode node) {
	 if(node == null) {
		 return -1;
	 }
	 int x =1 + Math.max(height(node.left), height(node.right));
	 return x;
	}

	//size of tree under the given node
	public int sizeR(BSTNode node){
		if(node==null){
			return 0;
		}
		return 1 + sizeR(node.left)+sizeR(node.right);
	}

	//size of tree under the given node - iterative way
	public int size(BSTNode node){
		int size=0;
		Stack s = new Stack();	
		s.push(node);
		while(!s.isEmpty()){
			BSTNode p= (BSTNode)s.pop();
			if(p!=null){
				size++;
				s.push(p.left);
				s.push(p.right);
			}
		}
		return size;
	}
	
	// modify search - on the way to finding the node, increment depth 
	public int depth(BSTNode node) {
	    BSTNode p=root;
	    int depth=0;

		while (p != null){
			if (node.el.equals(p.el)){
				return depth;
			} else if (node.el.compareTo(p.el) < 0){
				p = p.left;
				depth++;
			} else{
				p = p.right;
				depth++;
			}
		}
		return -1;
	}


	//Min
	public Comparable min(){
		BSTNode p=root;

		while(p.left!=null){
			p=p.left;
		}
		return p.el;
	}

	public Comparable minR(){
		if(isEmpty()) return null;
		return minR(root).el;
	}

	public BSTNode minR(BSTNode n){
		if(n.left==null){
			return n;
		}
		return minR(n.left);
	}


	//Max
	public Comparable max(){
		BSTNode p=root;

		while(p.right!=null){
			p=p.right;
		}
		return p.el;
	}

	public Comparable maxR(){
		if(isEmpty()) return null;
		return maxR(root).el;
	}

	public BSTNode maxR(BSTNode n){
		if(n.right==null){
			return n;
		}
		return maxR(n.right);
	}


//	
//	public int maxDepth(){
//		BSTNode p=root;
//		int maxD = 0;
//		int d=0;
//		
//		
//	}
	
	public BST copy(){
		BSTNode p = root;
		BST newTree = new BST();
		BSTNode q = new BSTNode(p.el);
		newTree.root=q;
		
		Queue<BSTNode> queue = new LinkedList<>();
		Queue<BSTNode> newQueue = new LinkedList<>();
		
		queue.add(p);
		newQueue.add(q);
		while (!queue.isEmpty()) {
			p =  queue.remove();
			q =  newQueue.remove();
			if (p.left != null){
				queue.add(p.left);
				q.left=new BSTNode(p.left.el);
				newQueue.add(q.left);
			}
			if (p.right != null){
				queue.add(p.right);
				q.right=new BSTNode(p.right.el);
				newQueue.add(q.right);
			}
		}
		return newTree;
	}
	
	public static boolean  compare(BST aTree, BST bTree){
		BSTNode a = aTree.root;
		BSTNode b = bTree.root;
		
		Queue<BSTNode> aQ =  new LinkedList<>();;
		Queue<BSTNode> bQ =  new LinkedList<>();;
		
		aQ.add(a);
		bQ.add(b);
		while (!aQ.isEmpty()) {
			a = aQ.remove();
			b = bQ.remove();
			if(a.el.compareTo(b.el) !=0){
				return false;
			}
			if (a.left != null){
				aQ.add(a.left);
			}
			if(b.left!=null){
				bQ.add(b.left);
			}
			if (a.right != null){
				aQ.add(a.right);
			}
			if(b.right !=null){
				bQ.add(b.right);
			}
		}
		return true;
	}
//	
//	public boolean check(){
//		Stack s = new Stack();
//		s.push(root);
//		
//		while(!s.isEmpty()){
//			BSTNode n = (BSTNode)s.pop();
//			
//			if(n.left!=null) {
//				if(n.left.el.compareTo(n.el)>=0) return false;
//				s.push(n.left);
//			}
//			if(n.right != null){
//				if(n.right.el.compareTo(n.el)<0) return false;
//				s.push(n.right);
//			}
//		}
//		return true;
//	}
	
	public boolean isBST(){
		Holder h = new Holder();
		check(root,h);
		return h.flag;
	}
	
	protected void check(BSTNode p, Holder h) {
		if (p != null & h.flag==true) {
			check(p.left,h);
			if(h.maxVal != null && p.el.compareTo(h.maxVal)<0) {
				h.flag=false;
				return;
			}
			h.maxVal= p.el;
			check(p.right,h);
		}
	}
	
	public boolean isBST2(){
		Holder h = new Holder();
		check2(null,root, h);
		return h.flag;
	}
	
	protected void check2(BSTNode prev, BSTNode p, Holder h){
		if (p != null) {
			check2(prev,p.left,h);
			if(prev!=null && prev.el.compareTo(p.el)>0){
					h.flag=false;
			}
			prev=p;
			check2(prev,p.right,h);
		}
	}
	
	
	static class Holder{
		boolean flag=true;
		Comparable maxVal;
	}
	
	public void reverse(){
		BST newTree = new BST();
		BSTNode n = null;
		
		while ((n=minR(root)) !=null){
			
		}
	}
}
