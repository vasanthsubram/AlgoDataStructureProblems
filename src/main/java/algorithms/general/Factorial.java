package algorithms.general;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;

public class Factorial {

	public static void main(String[] args) {
		int input = 16;
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(ONE.scale());
		int result = Factorial.factorialByRecursion(input);
		System.out.println("factorial = " + result);
		
		result = Factorial.factorialByLooping(input);
		System.out.println("factorial = " + result);
		
		BigDecimal num = new BigDecimal("16");
		System.out.println("Factorial = " + Factorial.compute(num));
	}

	public static int factorialByRecursion(int x){
		if(x==1){
			return 1;
		}else{
			return (x* factorialByRecursion(x-1));
		}
	}
	
	
	public static int factorialByLooping(int x){
		int result = 1;
		while(x>=2){
			result *= x;
			x--;
		}
		return result;
	}
	
	public static BigDecimal compute(BigDecimal x){
		
		if(x.compareTo(ONE)==0){
			return ONE;
		} else{
			BigDecimal result = x.setScale(0).multiply(compute(x.subtract(ONE)));
			return result;
		}
	}
}
