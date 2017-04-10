package algorithms.numbers.primes.detector;

import java.util.Arrays;

/**
 * All prime numbers under N
 *
 * Created by vasanth on 4/6/17.
 */
public class PrimeNumbersLessthanN {

    static int N=100;
    static int primeCount;

    public static void main(String[] args) {
        long[] primes=new long[N];
        primes[0]=2;
        primeCount++;
        findPrimes(N,primes);
        System.out.println(Arrays.toString(primes));
    }
    //if any number is not divisible by any of the prime numbers before it then that number is also prime
    public static void findPrimes(long N, long[] primes) {
        for(long i=3;i<N;i=i+2) {
            if(!isDivisibleByAnyOfLesserPrimes(i,primes)){
                primes[primeCount]=i;
                primeCount++;
            }
        }
    }

    private static boolean isDivisibleByAnyOfLesserPrimes(long input, long[] lesserPrimes){
        for (int i=0;i<primeCount;i++) {
            if ((input % lesserPrimes[i]) == 0)
                return true;
        }
        return false;
    }
}
