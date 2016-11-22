package algorithms.numbers.primes.sieveOfEratosthenes;

import java.util.ArrayList;

public class Standard {

	public static void main(String[] args) {
		int MAX = 100;
		
		ArrayList<Integer> result = Standard.findPrimes(MAX);
		System.out.println("List of Primes upto  " + MAX);
		for(int i: result){
			System.out.print(i + ",");
		}
	}

	/**
	 * This routine finds prime by standard procedure The maximum number upto
	 * which the prime number is limited
	 * 
	 * @param N
	 *            - The maximum number upto which the prime number
	 * @return int[] - array containing primes
	 */
	public static ArrayList<Integer> findPrimes(int N) {
		boolean a[] = new boolean[N];
		// assume all numbers are prime
		for (int i = 2; i < N; i++) {
			a[i] = true;
		}

		for (int i = 2; i < N; i++) {
			if (a[i] == true) {
				for (int j = i; (j * i) < N; j++) {
					a[j * i] = false; // not prime
				}
			}
		}
		System.out.println("Standard method: ");
		ArrayList<Integer> result=new ArrayList<Integer>();
		for(int i=0,j=0;i<a.length;i++){
			if(a[i]){			
				result.add(i);
			}
		}
		return result;
	}
}
