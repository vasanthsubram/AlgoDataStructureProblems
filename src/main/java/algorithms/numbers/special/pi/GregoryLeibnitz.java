package algorithms.numbers.special.pi;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static algorithms.numbers.MathUtils.PI_1000;
import static core.strings.CommonSubstring.SubstringFromStart;

public class GregoryLeibnitz {

	public static void main(String[] args) {
		BigDecimal pi = new BigDecimal("0.0");
		BigDecimal FOUR = new BigDecimal("4.0");
		boolean positive = true;
		for(long i=1;i<2000000;i=i+2){
			BigDecimal nextTerm = FOUR.divide(new BigDecimal(i),100,RoundingMode.HALF_UP);
			if(positive){
				pi=pi.add(nextTerm);
				positive=false;
			} else{
				pi=pi.subtract(nextTerm);
				positive=true;
			}
		}
		
		System.out.println("Authentic value = " + PI_1000);
		System.out.println("Calculated valu = " + pi);
		String common =SubstringFromStart(PI_1000, pi.toPlainString());
		
		System.out.println("verified computed value upto = " + common.length());
		System.out.println("verified computed value = " + common);
	}
}
