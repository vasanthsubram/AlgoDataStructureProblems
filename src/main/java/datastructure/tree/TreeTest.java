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
//		tree=unbalancedTree();
//		tree.print();
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
	
		//checking
//		System.out.println("Is tree correct = "+ tree.isBST());
//		tree.print();
//		System.out.println();
//		tree.root.left.right.el= 88;
//		System.out.println("Is tree correct = "+ tree.isBST());
//		tree.print();
		
//		tree.deleteByCopying(50);
//		tree.print();
	
//		System.out.println(tree.getHeight(tree.root));
//		System.out.println(tree.size(tree.root));
//		System.out.println(tree.sizeIterative(tree.root));		
//		tree.print();
		
		
		BST copy = tree.copy();
		tree.print();
		System.out.println();
		copy.print();
//		if(BST.verify(tree, copy)){
//			System.out.println("Both the trees are identical");
//		}
//		copy.root.right=null;
//		if(!BST.compare(tree, copy)){
//			System.out.println("Both the trees are not identical");
//		}

		//		System.out.println(tree.depth(tree.root.left.left.right.left));

		//min and max
//		System.out.println("Minimum by iteration = " + tree.min());
//		System.out.println("Maximum by iteration = " +tree.max());
//		
//		System.out.println("Minimum by recursion = " + tree.minR());
//		System.out.println("Maximum by recursion = " +tree.maxR());
		
		
//		System.out.println("Pre order");
//		tree.preorder();
//		System.out.println();
//		System.out.println("Post order");
//		tree.postorder();
//		System.out.println("In order");
//		tree.inorder();
		
//		System.out.println("Iterative pre order");
//		tree.iterativePreorder();
//		System.out.println();

//		
//		System.out.println("iterativeInorder");
//		tree.iterativeInorder();
//		System.out.println();
//		
//		System.out.println("Iterative post order");
//		tree.iterativePostorder2();
		
//		System.out.println("inorder");
//		tree.inorder();
//		System.out.println();
//		System.out.println("breadthFirst");
//		tree.breadthFirst();
	}


	static BST unbalancedTree(){
		BST tree = new BST();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		tree.insert(7);
		tree.insert(8);
		tree.insert(9);
		tree.insert(10);

		return tree;
	}
	
}
