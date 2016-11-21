package algorithms.numbers.primes.sieveOfEratosthenes;

import algorithms.numbers.primes.detector.PrimeDetector;
import utils.Stopwatch;

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		int MAX = 10000000;

		System.out.println("MAX = " + MAX);
		PrimeDetector detector = new PrimeDetector();
		boolean a[] = new SieveOfEratosthenes().findPrimesEnhanced(MAX);
		int b[] = new SieveOfEratosthenes().findPrimesEnhanced2(MAX);
		// new SieveOfEratosthenes().findPrimesStandard(MAX);
		int count1 = 0, count2 = 0;

		for (int i = 2; i < a.length; i++) {
			if (a[i]) {
				// detector.isPrime(i);
				count1++;
			}
		}

		for (int i = 2; i < MAX; i++) {
			// System.out.println(String.format("Bit array %x", b[i]));
			if ((b[i / 32] & (1 << (i % 32))) == 0) {
				// System.out.println(i/32);
				// System.out.println(i);
				// System.out.println(i + " is prime");
				count2++;
			}
		}

		System.out.println("Number of primes with the enhanced method: "
				+ count1);
		System.out.println("Number of primes with the enhanced  method2: "
				+ count2);

	}

	/**
	 * This routine finds prime by standard procedure
	 * The maximum number upto which the prime number is limited
	 * @param N - The maximum number upto which the prime number
	 * @return boolean[]  - returns boolean array - index of the array is a prime
	 *         number, if at that index true was stored; otherwise non-prime
	 */
	public boolean[] findPrimesStandard(int N) {
		Stopwatch stopWatch = new Stopwatch();
		boolean a[] = new boolean[N];
		int steps = 0;
		// assume all numbers are prime
		for (int i = 2; i < N; i++) {
			a[i] = true;
			steps++;
		}

		for (int i = 2; i < N; i++) {
			steps++;
			if (a[i] == true) {
				steps++;
				for (int j = i; (j * i) < N; j++) {
					steps++;
					// System.out.println(i*j);
					a[j * i] = false; // not prime
				}
			}
		}
		System.out.println("Standard method: ");
		stopWatch.elapsedTimeAndSpace();
		System.out.println("Number of steps in standard = " + steps);
		return a;
	}

	/**
	 * Improves the standard method by stopping the seive at square root of the
	 * MAX
	 * 
	 * @param N -
	 *            The maximum number upto which the prime number will be
	 *            searched
	 * @return boolean[] - returns boolean array - index of the array is a prime
	 *         number, if at that index true was stored; otherwise non-prime
	 */
	public boolean[] findPrimesEnhanced(int N) {
		Stopwatch stopWatch = new Stopwatch();
		boolean a[] = new boolean[N];
		int steps = 0;
		System.out
				.println("Size of boolean array allocated: Enhanced method:  "
						+ a.length);
		// the index of the array represents the number to be determined for
		// primacy
		// 2 is prime here
		a[2] = true;

		for (int i = 3; i < N; i = i + 2) {
			steps++;
			// only check for odd numbers; we know even numbers are not prime
			a[i] = true;
		}
		a[N - 1] = true;
		// i=i+2 => ignore even numbers
		int outerCount = 0;
		int innerCount = 0;
		// i is always odd because even numbers are not prime and product of odd
		// and even number
		// is always even
		for (int i = 3; i <= Math.sqrt(N); i = i + 2) {
			steps++;
			outerCount++;
			if (a[i] != false) {
				steps++;
				for (int j = i; i * j < N; j = j + 2) {
					innerCount++;
					steps++;
					a[j * i] = false; // mark as not prime
				}
			}
		}

		// System.out.println("Number iteration of outer loop in the enhanced
		// method= " + outerCount);
		// System.out.println("Number iteration of inner loop in the enhanced
		// method= " + innerCount);
		// System.out.println("Number of steps in enhanced = "+ steps);
		System.out.println("Ehanched method :  ");
		stopWatch.elapsedTimeAndSpace();

		return a;
	}

	/**
	 * Improving the standard method by stopping the iterations at the square
	 * root of the N (max number) and storing the result in the bits of integer
	 * This optimizes the size but takes more time
	 * 
	 * @param N -
	 *            The maximum number (MAX) upto which the prime number will be
	 *            searched
	 * @return int[] - each bit in the array represents the result - 
	 * 					0 indicates  prime; 
	 * 					1 indicates non-prime
	 */
	public int[] findPrimesEnhanced2(int N) {
		Stopwatch stopWatch = new Stopwatch();
		int a[] = new int[(N / 32) + 1];
		System.out.println("size of int array allocated: Enhanced 2: "
				+ a.length);

		for (int i = 0; i < a.length; i++) {
			a[i] = 0; // mark all prime
		}
		for (int i = 2; i <= Math.sqrt(N); i++) {
			boolean isPrime = ((a[i / 32] & (1 << (i % 32))) == 0);
			if (isPrime) {
				int arrLen = a.length;
				for (int j = i; ((j * i < N) & ((j * i) / 32) < arrLen); j++) {
					a[(j * i) / 32] |= (1 << (i * j) % 32);
				}
			}
		}
		System.out.println("Ehanched method 2:  ");
		stopWatch.elapsedTimeAndSpace();
		return a;
	}

}
