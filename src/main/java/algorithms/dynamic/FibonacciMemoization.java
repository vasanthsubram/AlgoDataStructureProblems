package algorithms.dynamic;

/**
 * Created by vasanthakumarsubramanian on 1/2/17.
 */
public class FibonacciMemoization {

    static long f[];
    public static void main(String args[]) {
        int n=20;
        f=new long[n+1];
        long result = fib(n);
        System.out.println(result);
    }

    static long fib(int n) {
        if (n < 2) return n;
        if(f[n]>0) return  f[n];

        f[n]= fib(n - 1) + fib(n - 2);
        return  f[n];
    }
}
