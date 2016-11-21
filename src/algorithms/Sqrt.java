package algorithms;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;

public class Sqrt {

	public static BigDecimal SQRT_2(){
		BigDecimal result = new BigDecimal(3);
		BigDecimal TWO = new BigDecimal(2);
		
		for(int i=1;i<100;i++){
			BigDecimal temp = ONE.divide(result, 100, BigDecimal.ROUND_HALF_UP);
			result=TWO.add(temp);
		}
		result = ONE.divide(result, 100, BigDecimal.ROUND_HALF_UP);
		result = result.add(ONE);
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(Sqrt.SQRT_2());
	}
}
