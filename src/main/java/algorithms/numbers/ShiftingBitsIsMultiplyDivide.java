package algorithms.numbers;

public class ShiftingBitsIsMultiplyDivide {

  public static void main(String[] args) {
    int x = 1;
    System.out.println("Left shift is equivalent to multiplying by 2");
    for (int i = 0; i < 5; i++) {

      System.out.print(" 1 << " +i +" = " );
      System.out.println( x << i);
    }
    System.out.println();
    System.out.println("Right shift is equivalent to dividing by 2");
    x=1000;
    for (int i = 0; i < 4; i++) {
      System.out.print(" 1000 >> " +i +" = " );
      System.out.println( x >> i);
    }
  }

}
