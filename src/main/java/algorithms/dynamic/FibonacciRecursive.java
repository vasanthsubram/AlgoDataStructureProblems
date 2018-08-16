package algorithms.dynamic;

/**
 * Recursively calculate the kth FibonacciRecursive number.
 * Inefficent
 * 
 * @author cuttle-fish
 */
public class FibonacciRecursive {

    public static void main(String args[]) {
        long result = fib(5);
        System.out.println(result);
    }
    
    static long fib(long k) {
        System.out.println(k);
        if (k < 2) {
            return k;
        } else {
            return fib(k - 1) + fib(k - 2);
        }
    }
}
