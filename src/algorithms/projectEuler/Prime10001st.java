package algorithms.projectEuler;

import java.util.ArrayList;
import java.util.List;

public class Prime10001st {

	/*
	 	By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

		What is the 10 001st prime number?
	 */
	public static void main(String[] args) {
		
		int MAX = 10001;
		long start = System.currentTimeMillis();
		
		List<Integer> primes = new ArrayList<Integer>(MAX);
		primes.add(2);
		
		for(int i=3;primes.size()<=MAX;i=i+2){
			if(isPrime(primes,i)){
				primes.add(i);
			}
		}
		System.out.println("Total time taken in ms = " + (System.currentTimeMillis()-start));
		System.out.println("The " + MAX + " prime is = " + primes.get(MAX-1));
	}

	
	static boolean isPrime(List<Integer> primes, int x){
		for(int i=0;i<primes.size();i++){
			if(x % primes.get(i)==0){
				return false;
			}
		}
		return true;
	}
}
