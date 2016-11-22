package algorithms.numbers.roots;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SquareRootBigDecimalVersion {
    // Number of iterations

    private static final int MAX_ITER = 100;
    // The number for which the square root is needed
    static BigDecimal input = new BigDecimal("100");
    // 2 -convenience
    static BigDecimal TWO = new BigDecimal("2");
    // precision
    static int P = 10;

    public static void main(String[] args) {
        System.out.println(" root of " + input.toString() + "  =  " + findRoot(input));

    }

    public static BigDecimal findRoot(BigDecimal input) {
        // initial estimate
        BigDecimal estimate = input.divide(TWO);

        BigDecimal newEstimate = null;
        RoundingMode mode = RoundingMode.FLOOR;

        BigDecimal x, y;
        for (int i = 0; i < MAX_ITER; i++) {
            /*
             * newEstimate = (estimate + (N/estimate))/2
             */
            x = input.divide(estimate, P, mode);
            y = estimate.add(x);
            newEstimate = y.divide(TWO, P, mode);
            System.out.println(newEstimate);
            if (estimate.equals(newEstimate)) {
                break;
            }
            estimate = newEstimate;
        }
        return newEstimate;
    }
}
