package algorithms.numbers;

public class NumberDigits {
  public static void main(String[] args){
    System.out.println(isDivisible(5,3));
    System.out.println(isDivisible(15,3));

    System.out.println(isEven(5));
    System.out.println(isEven(-6));

    digitsInNumber(12345);
    sumOfDigitsInNumber(12345);

    reverseDigitsOfNumber(12345);
  }
  static boolean isDivisible(int n, int k){
    return n%k==0;
  }

  static boolean isEven(int n){
    return n%2==0;
  }

  static void digitsInNumber(int x){
    while(x != 0){
      System.out.println(x%10);
      x =x/10;
    }
  }

  static void sumOfDigitsInNumber(int x){
    int sum=0;
    while(x != 0){
      sum = sum + x%10;
      x =x/10;
    }
    System.out.println(sum);
  }

  static void reverseDigitsOfNumber(int n){
    StringBuilder s = new StringBuilder();

    while(n!=0){
      s.append(n%10);
      n=n/10;
    }
    System.out.println(s.toString());
  }
}
