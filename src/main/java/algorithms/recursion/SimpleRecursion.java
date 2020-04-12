package main.java.algorithms.recursion;

public class SimpleRecursion {

  public static void main(String []args) {
    new SimpleRecursion().reduceByOne(5);
  }

  public void reduceByOne(int n) {
    System.out.println("Push "+n);
    if(n > 0) {
      reduceByOne(n-1);
    }
    System.out.println("Pop "+n);
  }
}