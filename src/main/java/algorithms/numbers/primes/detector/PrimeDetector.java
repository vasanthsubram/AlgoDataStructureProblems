package algorithms.numbers.primes.detector;

public class PrimeDetector {
	private static int count = 0;
	public static void main(String args[]){
	
		long input = 420250692582001L;
		//long input = 3300454891L;
		//long input = 439;
		long start = System.currentTimeMillis();
			System.out.println(input + "  is " + ((isPrime(input)) ? "Prime" : " not prime"));
		long timeToCalc = System.currentTimeMillis()-start;
		
		System.out.println("Number of iterations to detect = " + count);
		System.out.println("Time to compute = " + timeToCalc);
	}
	
	public static boolean isPrime(long input) {
		boolean result = true;
		
		if (input == 2) 
			return true;
		
		if ((input % 2) == 0)
			return false;

		/*
		 *	If input is composite, it must be a divisible by factors (f1 < f2 < f3...fm) each < input.
		 *	f1 * f2 * f3 * f4 *...fm = input
		 *	If f1 proves to be not a factor then maxValueToBeSearched has to be (f1 * f2 * f3 *...fm)/f1
		 *	Initially we can assume the maxValueToBeSearched to be the input value.
		 */
		long maxValueToBeSearched=input;
		
		for (long i = 3; i < maxValueToBeSearched; i = i + 2)
		{
		//	System.out.println( "For i = " + i + " Max value to be searched = " + maxValueToBeSearched);
			count++;
			if ((input % i) == 0) {
				System.out.println("Divisible by  " + i);
				return false;
			} else{
				//i is not a factor
				maxValueToBeSearched=input/i;
			}
		}
		return result;
	}

}
