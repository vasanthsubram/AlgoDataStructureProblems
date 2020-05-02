package main.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ScratchTree {

  public static void main(String[] args) {

    /*
           5
        /    \
       3      7
        \     /
         4   6
     */
    BST bst = new BST();
    bst.add(5);
    bst.add(7);
    bst.add(3);
    bst.add(4);
    bst.add(6);

    System.out.println("in order");
    bst.inOrder();
    System.out.println("pre order");
    bst.preOrder();
    System.out.println("post order");
    bst.postOrder();

    System.out.println("DFS");
    bst.dfs();

    System.out.println("find");
    System.out.println(bst.find(4));

    System.out.println("max");
    System.out.println(bst.max());

    System.out.println("max recursion");
    System.out.println(bst.max2());

    System.out.println("Copy tree");
    BST copy = bst.copy();
    copy.inOrder();
  }

  static class BST{
    BSTNode root;

    public void add(int val){
      BSTNode node = new BSTNode();
      node.data = val;

      if(root==null){
        root = node;
        return;
      }
      BSTNode p = root, prev = null;
      while(p != null) {
        prev = p;
        if (p.data > val) {
          p = p.left;
        } else {
          p = p.right;
        }
      }

      if(prev.data > val){
        prev.left = node;
      } else{
        prev.right = node;
      }
    }

    public void inOrder(){
      BSTNode p = root;
      Stack<BSTNode> stack = new Stack();
      while (!stack.isEmpty() || p != null) {
        if( p != null) {
          stack.push(p);
          p = p.left;
        } else{
          p = stack.pop();
          visit(p);
          p = p.right;
        }
      }
    }

    public void preOrder(){
      Stack<BSTNode> stack = new Stack();
      stack.push(root);
      while(!stack.isEmpty()) {
        BSTNode p = stack.pop();
        visit(p);
        if(p.right != null) {
          stack.push(p.right);
        }
        if(p.left != null) {
          stack.push(p.left);
        }
      }
    }

    public void postOrder(){
      Stack<BSTNode> stack = new Stack<>();
      Stack<BSTNode> temp = new Stack<>();

      temp.push(root);

      while(!temp.isEmpty()){
        BSTNode p = temp.pop();
        stack.push(p);
        if(p.left != null) {
          temp.push(p.left);
        }
        if(p.right != null) {
          temp.push(p.right);
        }

      }
      while(!stack.isEmpty()){
        BSTNode p = stack.pop();
        visit(p);
      }
    }

    public void dfs(){
      Queue<BSTNode> queue = new LinkedList<>();
      queue.add(root);

      while(!queue.isEmpty()){
        BSTNode p = queue.remove();
        visit(p);
        if(p.left != null){
          queue.add(p.left);
        }
        if(p.right != null){
          queue.add(p.right);
        }
      }
    }

    public int find(int val){
      BSTNode p = root;

      while(p != null) {
        if (p.data == val) {
          visit(p);
          return p.data;
        }
        if (val < p.data) {
          p = p.left;
        } else {
          p = p.right;
        }
      }
      return -1;
    }

    public int max(){
      BSTNode p = root;

      while( p.right != null){
        p = p.right;
      }
      return p.data;
    }

    public int max2(){
      return max2(root).data;
    }

    public BSTNode max2(BSTNode p){
      if(p.right==null){
        return p;
      }
      return p.right;
    }
    public void visit(BSTNode p){
      System.out.println(p.data);
    }

    public BST copy(){
      BST newTree = new BST();
      BSTNode newRoot = new BSTNode(root.data);
      newTree.root = newRoot;
      Queue<BSTNode> oldTreeQueue = new LinkedList<>();
      Queue<BSTNode> newTreeQueue = new LinkedList<>();

      oldTreeQueue.add(root);
      newTreeQueue.add(newRoot);

      while (!oldTreeQueue.isEmpty()) {
        BSTNode x = oldTreeQueue.remove();
        BSTNode y = newTreeQueue.remove();

        if (x.left != null) {
          oldTreeQueue.add(x.left);
          y.left = new BSTNode(x.left.data);
          newTreeQueue.add(y.left);
        }

        if (x.right != null) {
          oldTreeQueue.add(x.right);
          y.right = new BSTNode(x.right.data);
          newTreeQueue.add(y.right);
        }
      }
      return newTree;
    }
  }


  static class BSTNode{
    BSTNode left, right;
    int data;

    public BSTNode(){}

    public BSTNode(int val){
      data = val;
    }
  }


}
