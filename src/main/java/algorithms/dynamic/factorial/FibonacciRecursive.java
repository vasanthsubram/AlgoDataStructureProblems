package algorithms.dynamic.factorial;

/**
 * Recursively calculate the kth FibonacciRecursive number.
 * Inefficent
 * 
 * @author cuttle-fish
 */
public class FibonacciRecursive {

    public static void main(String args[]) {
        long result = fib(20);
        System.out.println(result);
    }
    
     static long fib(long k) {
        if (k <= 1) return k;
        return fib(k - 1) + fib(k - 2);
    }
}
