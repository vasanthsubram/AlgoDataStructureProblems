package algorithms.numbers.special.e;

import algorithms.dynamic.factorial.Factorial;

import java.math.BigDecimal;

import static core.strings.CommonSubstring.SubstringFromStart;
import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ROUND_HALF_UP;

;

public class CalculateE {

	static String E_1000 =("2.7182818284 5904523536 0287471352 6624977572 4709369995 9574966967 6277240766 3035354759 4571382178 5251664274 2746639193 2003059921 8174135966 2904357290 0334295260 5956307381 3232862794 3490763233 8298807531 9525101901 1573834187 9307021540 8914993488 4167509244 7614606680 8226480016 8477411853 7423454424 3710753907 7744992069 5517027618 3860626133 1384583000 7520449338 2656029760 6737113200 7093287091 2744374704 7230696977 2093101416 9283681902 5515108657 4637721112 5238978442 5056953696 7707854499 6996794686 4454905987 9316368892 3009879312 7736178215 4249992295 7635148220 8269895193 6680331825 2886939849 6465105820 9392398294 8879332036 2509443117 3012381970 6841614039 7019837679 3206832823 7646480429 5311802328 7825098194 5581530175 6717361332 0698112509 9618188159 3041690351 5988885193 4580727386 6738589422 8792284998 9208680582 5749279610 4841984443 6346324496 8487560233 6248270419 7862320900 2160990235 3043699418 4914631409 3431738143 6405462531 5209618369 0888707016 7683964243 7814059271 4563549061 3031072085 1038375051 0115747704 1718986106 8739696552 1267154688 9570350354").replace(" ", "");
	
	/**
	 Sum(1/n!)
	 * @return
	 */
	static BigDecimal computeE(){
		int TERMS =1000;
		int scale = 1000;
		BigDecimal result=ONE;
		for(int i=1;i<=TERMS;i++){
			BigDecimal factorial = Factorial.compute(new BigDecimal(i));
			result = result.add(ONE.divide(factorial,scale,ROUND_HALF_UP));
//			System.out.println(result);
		}
		return result;
	}
	
	public static void main(String[] args) {
//		System.out.println(E_1000.length());
		BigDecimal result = CalculateE.computeE();
		System.out.println();
		System.out.println("The real value of e");
		System.out.println(E_1000);
		System.out.println("the computed value of e");
		System.out.println(result.toPlainString());
		String common =SubstringFromStart(E_1000, result.toPlainString());
		System.out.println("E computed upto this many places: " + common.length());
		
		System.out.println();
		System.out.println("This is the portion common to the real value");
		System.out.println(common);
	}
}
