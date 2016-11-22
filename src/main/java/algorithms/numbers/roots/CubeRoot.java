package algorithms.numbers.roots;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CubeRoot {
	// Number of iterations
	private static final int MAX = 100;

	public static void main(String[] args) {
		// The number for which the square root is needed
		BigDecimal N = new BigDecimal("625");
		// 2 -convenience
		BigDecimal TWO = new BigDecimal("2");
		// 2 -convenience
		BigDecimal THREE = new BigDecimal("3");
		
		// initial estimate
		BigDecimal estimate = N.divide(TWO);
		// precision
		int P = 100;

		BigDecimal newEstimate = null;
		RoundingMode mode = RoundingMode.FLOOR;

		BigDecimal x1,x2,x3;
		for (int i = 0; i < MAX; i++) {
			x1=TWO.multiply(estimate);
			x2=estimate.multiply(estimate);
			x3=N.divide(x2, P, mode);
			newEstimate = (x1.add(x3)).divide(THREE, P, mode);
			System.out.println(newEstimate);
			estimate = newEstimate;
		}

		System.out.println("Cube root of " + N + " = " + newEstimate);
		System.out.println("Cube root of " + N + " = " + Math.pow(N.doubleValue(),1.0/3.0));
	}

}
