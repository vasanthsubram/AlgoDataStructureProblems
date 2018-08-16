package algorithms.dynamic;

/**
 * Created by vasanthakumarsubramanian on 1/2/17.
 */
public class FibonacciMemoization {

    static long fibMem[];
    public static void main(String args[]) {
        int n=50;
        fibMem=new long[n];
        long result = fib(n);
        System.out.println(result);
    }

    static long fib(int k) {
        if (k < 2) {
            return k;
        } else {
            if(fibMem[k-1]==0){
                fibMem[k-1]= fib(k - 1) + fib(k - 2);
            }
            return fibMem[k-1];
        }
    }
}
