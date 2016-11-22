package algorithms.numbers.special.pi;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static algorithms.numbers.MathUtils.PI_1000;
import static core.strings.CommonSubstring.SubstringFromStart;

/**
 	Gregory�Leibniz series
  	pi = 3 + (4/(2*3*4)) - (4/(4*5*6)) + (4/(6*7*8)) - (4/(8*9*10)) + .....
  
 * @author subramav
 *
 */
public class Nilakantha {

	public static void main(String[] args) {
		BigDecimal pi = new BigDecimal(3);
		BigDecimal FOUR = new BigDecimal(4);
		boolean flag = true;
		int iterations = 2000000;
		int precision = 100;
		
		for(long i=0,j=2;i<iterations;i++,j=j+2){
			BigDecimal denom = multAsBigD(j, (j+1), (j+2));
			BigDecimal term = FOUR.divide(denom,precision,RoundingMode.HALF_EVEN);
			if(flag) {
				pi=pi.add(term);
			} else {
				pi=pi.subtract(term);
			}
			
			flag = !flag;
		}
		
		System.out.println("Authentic value = " + PI_1000);
		System.out.println("Calculated valu = " + pi);
		String common =SubstringFromStart(PI_1000, pi.toPlainString());
		
		System.out.println("verified computed value upto = " + common.length());
		System.out.println("verified computed value = " + common);
	}
	
	static BigDecimal multAsBigD(long i, long j, long k){
		return (new BigDecimal(i).multiply(new BigDecimal(j))).multiply(new BigDecimal(k));
	}
	
}
