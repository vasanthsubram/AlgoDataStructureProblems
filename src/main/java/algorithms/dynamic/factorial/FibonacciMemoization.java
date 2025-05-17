package algorithms.dynamic.factorial;

import java.util.Arrays;

/**
 * Created by vasanthakumarsubramanian on 1/2/17.
 */
public class FibonacciMemoization {

    static long cache[];
    public static void main(String args[]) {
        // 1 1 2 3 5 8
        int n=6;
        cache=new long[n+1];
        long result = fib(n);
        System.out.println(result);
    }

    static long fib(int n) {
        if (n <=1 ) return n;
        if(cache[n]>0) return  cache[n];

        cache[n]= fib(n - 1) + fib(n - 2);
        System.out.println(Arrays.toString(cache));
        return  cache[n];
    }
}
