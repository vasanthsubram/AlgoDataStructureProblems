package datastructure.tree;



public class TreeTest {

	public static void main(String[] args) {
		/*
		 				   87
		 				/      \
		 			50			111
		 		   /  \          /
		 		27		58	    99		  
		 		\			    / \ 
		 	 	 42	          90  105	
		 		/		
		 	   32	
		 */		
		
		BST tree = new BST();
		tree.insert(87);
		tree.insert(50);
		tree.insert(27);
		tree.insert(111);
		tree.insert(99);
		tree.insert(42);
		tree.insert(90);
		tree.insert(105);
		tree.insert(58);
		tree.insert(32);

		System.out.println();

//		tree.iterativePreOrder();
		tree.iterativePostorder_p();

		System.out.println();
		tree.iterativeInOrder_p();


		System.out.println("\nPrint tree");
		tree.print();
//		System.out.println(tree.depth(new BSTNode(32)));

		System.out.println();
		System.out.println("tree height = " + tree.height(tree.getRoot()));
	}


	static BST unbalancedTree() {
		BST tree = new BST();
		tree.insert(3);
		tree.insert(2);
		tree.insert(1);
		return tree;
	}
}
