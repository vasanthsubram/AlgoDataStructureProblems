package algorithms.numbers.primes.detector;

public class RawPrimeDetector {
	
	public static void main(String args[]){
	
		long input = 4202506923427L;
			System.out.println(input + "  is " + ((isPrime(input)) ? "Prime" : " not prime"));
	}
	
	public static boolean isPrime(long input) {
		boolean result = true;
		
		if (input == 2) 
			return true;
		
		if ((input % 2) == 0)
			return false;
		
		long MAX = (long)Math.sqrt(input) +1; 
		for (long i = 3; i < MAX; i = i + 2) {
			if ((input % i) == 0) {
				System.out.println("Divisible by  " + i);
				return false;
			}
		}
		return result;
	}

}
