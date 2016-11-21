package algorithms.numbers.primes.detector;

import algorithms.numbers.roots.SquareRootBigDecimalVersion;

import java.math.BigDecimal;
import java.math.BigInteger;

public class PrimeDetectorBigIntegerSquareRootVersion {

	static BigInteger ZERO = new BigInteger("0");
	static BigInteger ONE = new BigInteger("1");
	static BigInteger TWO = new BigInteger("2");
	static BigInteger THREE = new BigInteger("3");
	
	/*
	 * sample primes
		2, 3, 5, 7, 23, 719, 5039, 39916801, 479001599, 87178291199, 10888869450418352160768000001
		265252859812191058636308479999999
		263130836933693530167218012159999999, 8683317618811886495518194401279999999
	*/
	
	public static void main(String args[]){
		PrimeDetectorBigIntegerSquareRootVersion instance = new PrimeDetectorBigIntegerSquareRootVersion();
		String target = "2305843009213693951";
		System.out.println(instance.isPrime(target));
	}
	
	public boolean isPrime(String a) {
		if(a==null | a.length()==0){
			System.out.println("Null or empty string is not a valid integer");
			return false;
		}
		
		boolean result = true;
		BigInteger input = (new BigInteger(a.trim())).abs();
		
		if (input.remainder(TWO).equals(ZERO)){
			System.out.println(input.toString()+ " is even and therefore not a prime");
			return false;
		}

		BigInteger i;
		BigInteger root=SquareRootBigDecimalVersion.findRoot(new BigDecimal(input)).toBigInteger();
		BigInteger root_plus_one=root.add(ONE);
		System.out.println("Square root of " + input + " = " + root);
		for (i = THREE; (i.compareTo(root_plus_one))== -1; i = i.add(TWO)) {
			if (input.remainder(i).equals(ZERO)) {
				System.out.println("Divisible by  " + i.toString() + " and therefore not a prime");
				return false;
			}
		}
		System.out.println(input + " is prime");
		return result;
	}

	

}
