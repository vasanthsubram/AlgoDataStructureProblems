package algorithms.numbers.primes.sieveOfEratosthenes;

import java.util.ArrayList;

public class Improved {

	public static void main(String[] args) {
		int MAX = 5000;
		System.out.println("MAX = " + MAX);
		ArrayList<Integer> result = new Improved().findPrimes(MAX);
		for(int i: result){
			System.out.print(i + ",");
		}
	}


	/**
	 * Improves the standard method by stopping the seive at square root of the
	 * MAX
	 * 
	 * @param N -
	 *            The maximum number upto which the prime number will be
	 *            searched
	 * @return int[] - array containing primes
	 */
	public ArrayList<Integer> findPrimes(int N) {
		boolean a[] = new boolean[N];
		// 2 is prime here
		a[2] = true;

		//all array elements default to false; mark the odd elements as true 
		for (int i = 3; i < N; i = i + 2) {
			a[i] = true;
		}
		a[N - 1] = true;

		for (int i = 3; i <= Math.sqrt(N); i = i + 2) {
			if (a[i] == true) {
				for (int j = i; i * j < N; j = j + 2) {
					a[j * i] = false; //not prime
				}
			}
		}
		ArrayList<Integer> result=new ArrayList<Integer>();
		for(int i=0,j=0;i<a.length;i++){
			if(a[i]){			
				result.add(i);
			}
		}
		return result;
	}
}
