package algorithms.recursion;

public class Factorial {

    public static void main(String[] args) {
        int input = 10;
        int result = new Factorial().factorial(input);
        System.out.println("factorial = " + result);
    }

    public int factorial(int x) {
        if (x == 1) {
            return 1;
        } else {
            return (x * factorial(x - 1));
        }
    }
}
