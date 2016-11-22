package algorithms.numbers.special.phi;

import java.math.BigDecimal;

import static algorithms.numbers.MathUtils.PHI_973;
import static core.strings.CommonSubstring.SubstringFromStart;
import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ROUND_HALF_UP;

public class CalculatePhi {
	/*
	  			1
	  	1 + --------
	  	   	1 +  1
	  	   	  ------
	  	   	    1 + 1
	  	   	        ----
	  	   	         :
	 * 
	 */
	public static BigDecimal PhiFromContinuedFraction(){
		int TERMS = 10240;
		int scale = 1000;
		BigDecimal result=ONE;
		
		for(int i=1;i<=TERMS;i++){
			result = result.add(ONE);
			result = ONE.divide(result, scale, ROUND_HALF_UP);

		}
	
		//left-most ONE
		result = result.add(ONE);
		
		return result;
	}
	
	public static void main(String[] args) {
		BigDecimal result = CalculatePhi.PhiFromContinuedFraction();
		System.out.println(PHI_973);
		System.out.println(result.toPlainString());
		String common =SubstringFromStart(PHI_973, result.toPlainString());
		System.out.println("PHI computed upto this many places: " + common.length());
		System.out.println(common);
	}
}
