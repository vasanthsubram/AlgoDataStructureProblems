package algorithms.recursion;

import datastructure.tree.BST;
import datastructure.tree.BSTNode;

public class RecursionProblems {

  public static void main(String[] args){
    RecursionProblems r = new RecursionProblems();

    //factorial
    System.out.println("factorial = " + r.factorial(8));

    //nth fibonnaci number
    System.out.println("fibonacci =" + r.fib(10));

    //sum of numbers
    System.out.println("sum = " + r.sum(7));

    //power of 10
    System.out.println("power of 10 = " + r.pow(5) );

    //digits of number
    System.out.println("digits = " + r.digits(8));

    //to binary
    System.out.println("binary = "+ r.toBinary(15));

    //reverse string
    String s = "why did the chicken cross the road ?";
    System.out.println(" reverse = " + r.rev(s, s.length()-1));

    //greatest common divisor
    int gcd = r.gcd(17,5);
    System.out.println("gcd = " + gcd);


    //determine if an array is sorted
    int[] a = {1,4,2,3};
    System.out.println("array is sorted = " + r.isSorted(a,a.length-1));

    //calculate height of a binary tree
    BSTNode root = r.getTree().getRoot();
    System.out.println("tree height = " + r.height(root));
  }

  public int factorial(int x) {
    if (x == 1) return 1;
    return (x * factorial(x - 1));
  }


  public int fib(int x){
    if(x<2) return x;
    return fib(x-1) + fib(x-2);
  }

  public int sum(int n){
    if(n==0) return 0;
    return n+sum(n-1);
  }

  public int pow(int n){
    if(n==0) return 1;
    return pow(n-1)*10;
  }

  public String digits(int n){
    if(n<10) return String.valueOf(n);
    return (n/10) + String.valueOf(n%10);
  }

  public String toBinary(int n){
    if(n<=1) return String.valueOf(n);
    return (toBinary(n/2)+String.valueOf(n%2));
  }

  public String rev(String s, int i) {
    if(i == 0) return ""+s.charAt(0);
    return s.charAt(i) + rev(s,i-1);
  }

  private boolean isSorted(int[] a, int i) {
    //base
    if(i==0){
      return true;
    }
    if(a[i]<a[i-1]){
      return false;
    }
    //recursive
    return isSorted(a, i-1);
  }


  public int gcd(int p, int q) {
    if (q == 0) return p;
    else return gcd(q, p%q);
  }

  //height of a binary tree
  //Height of node x = No of edges in longest path from x to a leaf node
  public int height(BSTNode n){
    if (n== null) return 0;
    System.out.println(n.el);
    if(n.isLeaf()) return 0;
    int ht = 1 + max(height(n.left),height(n.right));
    return ht;
  }

  private int max(int a,int b){
    return a>b ? a:b;
  }

  private BST getTree(){
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
    return tree;
  }
}
