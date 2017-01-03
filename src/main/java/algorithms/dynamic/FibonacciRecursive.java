package algorithms.dynamic;

/**
 * Recursively calculate the kth FibonacciRecursive number.
 * Inefficent
 * 
 * @author cuttle-fish
 */
public class FibonacciRecursive {

    public static void main(String args[]) {
        long result = new FibonacciRecursive().fib(1000);
        System.out.println(result);
    }
    
    long fib(long k) {
        if (k < 2) {
            return k;
        } else {
            return fib(k - 1) + fib(k - 2);
        }
    }
}
