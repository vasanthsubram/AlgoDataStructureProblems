package algorithms.numbers.primes.detector;

public class PrimeDetectorRoot {
	private static int count = 0;
	public static void main(String args[]){
	
		long input = 2305843009213693951L;
			System.out.println(input + "  is " + ((isPrime(input)) ? "Prime" : " not prime"));
			System.out.println("Number of iterations to detect = " + count);
	}
	
	/*
	 * If a number x,  is not divisible by any factor f less than the
	 * square root(x) then that number is prime.
	 * 
	 * This is because if the number x has a smallest factor f1, that is
	 * greater than its square root (x), then the next factor f2 will be
	 * greater than f1. f1*f2 will be greater than x itself, therefore they
	 * cannot be factors and so x is a prime number
	 */
	public static boolean isPrime(long input) {
		boolean result = true;
		
		if (input == 2) 
			return true;
		if ((input % 2) == 0)
			return false;
	
		double max= Math.sqrt(input);
		for (long i = 3; i <= max; i = i + 2) {
			count++;
			if ((input % i) == 0) {
				//System.out.println("Divisible by  " + i);
				return false;
			}
		}
		return result;
	}
	public static boolean isPrime(long input, long[] lesserPrimes) {
		boolean result = true;
		
		if (input == 2) 
			return true;
		if ((input % 2) == 0)
			return false;
	
		double max= Math.sqrt(input);
		for (long p : lesserPrimes) {
			
			if(p==0  || p>=max){
				return false;
			}
			if ((input % p) == 0) {
				//System.out.println("Divisible by  " + i);
				return false;
			}
		}
		return result;
	}
	
}
