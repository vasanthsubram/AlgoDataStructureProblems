package algorithms.numbers.primes;

import algorithms.numbers.primes.detector.PrimeDetector2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GenerateFirst10000Primes {

	public static void main(String[] args) throws FileNotFoundException {
		int MAX = 100000;
		long[] listOfPrimes = new long[MAX];
		int count = 0;
		listOfPrimes[0] =2;
		count++;
		for (int i = 3; count < MAX; i = i + 2) {
			if (PrimeDetector2.isPrime(i)) {
				listOfPrimes[count] = i;
				count++;
			}
		}
		PrintWriter w = new PrintWriter("output/first_nth_prime.txt");
		
		for (int k = 0; k < MAX; k++) {
			if(k%10==0){
				System.out.println();
				w.print("\n");
				w.print((k+1) + "\t\t");
			}
			System.out.print(listOfPrimes[k] + " ");
			w.print(listOfPrimes[k]);
			w.print("\t");
			
		}
		
		w.close();
	}

}
