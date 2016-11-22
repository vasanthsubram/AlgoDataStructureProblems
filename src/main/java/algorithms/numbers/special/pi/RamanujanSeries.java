package algorithms.numbers.special.pi;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RamanujanSeries {
	public static void main(String[] args) {
		
		BigDecimal sqrtOf2 = new BigDecimal(Math.sqrt(2));
		
		BigDecimal constant = new BigDecimal(2).multiply(sqrtOf2);
		constant=constant.divide(new BigDecimal(9801), 100, RoundingMode.HALF_UP);
		
		
		System.out.println(constant);
	}

}
