package algorithms.recursion;

/**
 * Recursively calculate the kth Fibonacci number.
 * 
 * @author cuttle-fish
 */
public class Fibonacci {

    public static void main(String args[]) {
        int result = new Fibonacci().fib(5);
        System.out.println(result);
    }
    
    int fib(int k) {
        if (k < 2) {
            return k;
        } else {
            return fib(k - 1) + fib(k - 2);
        }
    }
}
