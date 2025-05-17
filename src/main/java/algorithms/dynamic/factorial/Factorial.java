package algorithms.dynamic.factorial;

import java.math.BigDecimal;
import static java.math.BigDecimal.ONE;

public class Factorial {

	public static void main(String[] args) {
		int input = 16;
		System.out.println("recursive = " + Factorial.recursive(input));
		System.out.println("iterative = " + Factorial.iterative(input));
	}

	public static long recursive(long x){
		if(x==1){
			return 1;
		}
		return (x* recursive(x-1));
	}
	
	
	public static long iterative(long x){
		long result = 1;
		while(x>=2){
			result = result * x;
			x--;
		}
		return result;
	}

	public static BigDecimal compute(BigDecimal x){
		if(x.compareTo(ONE)==0){
			return ONE;
		}
		BigDecimal result = x.setScale(0).multiply(compute(x.subtract(ONE)));
		return result;
	}
}
