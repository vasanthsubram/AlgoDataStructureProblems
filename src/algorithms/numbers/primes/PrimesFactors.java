package algorithms.numbers.primes;

import java.util.ArrayList;
import java.util.List;

public class PrimesFactors {

	public static void main(String[] args) {
		int input = 966576587;
		List<Integer> factors = find(input);
		if(factors.size()==1){
			if(factors.get(0)==input){
				System.out.println(input + " is prime");
				return;
			}
		}
		
		System.out.println("Input = " + input);
		int result=1;
		for (int i : factors) {
			result= result*i;
			System.out.print(i + " * ");
		}
		
		System.out.println(" = " + result);
	}

	public static List<Integer> find(int input) {
		List<Integer> factors = new ArrayList<Integer>(128);
		for (int i = 2; i < input; i++) {
			if (input % i == 0) {
				input = input / i;
				factors.add(i);
			}
		}
		factors.add(input);
		return factors;
	}
}
