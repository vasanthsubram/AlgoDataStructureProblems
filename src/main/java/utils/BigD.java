package utils;

import java.math.BigDecimal;

public class BigD {

	public static BigDecimal bigD(int i){
		return new BigDecimal(i);
	}
	
	public static BigDecimal bigD(long i){
		return new BigDecimal(i);
	}
	
	public static BigDecimal bigD(String num){
		return new BigDecimal(num);
	}
}
