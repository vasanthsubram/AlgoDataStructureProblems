package main.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Scratch {

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
    bst.find(4);
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
        if ((p.left != null) &&val < p.left.data) {
          p = p.left;
        } else {
          p = p.right;
        }
      }
      return -1;
    }

    public void visit(BSTNode p){
      System.out.println(p.data);
    }
  }

  static class BSTNode{
    BSTNode left, right;
    int data;
  }


}
