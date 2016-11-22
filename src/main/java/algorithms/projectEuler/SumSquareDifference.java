package algorithms.projectEuler;

/*
 	The sum of the squares of the first ten natural numbers is,

	1*1 + 2*2 + ... + 10*10 = 385
	The square of the sum of the first ten natural numbers is,

	(1 + 2 + ... + 10)(1+2+...+10) = 552 = 3025
	Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025  385 = 2640.

	Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class SumSquareDifference {

	public static void main(String[] args) {

		//brute force
		
		long sumOfSquares = 0;
		for(int i=1;i<=100;i++){
			sumOfSquares = sumOfSquares + (i*i);
		}
		System.out.println("Sum of squares = " + sumOfSquares);
		long squareOfSums = 0;
		for(int i=1;i<=100;i++){
			squareOfSums += i;
		}
		squareOfSums *= squareOfSums;
		System.out.println("Squares of sum= " + squareOfSums);
		System.out.println(squareOfSums - sumOfSquares);

		System.out.println();
		
		
		//elegant method
		
		long limit = 100;
		long sum = (limit*(limit + 1))/2;
		long sum_sq = ((2*limit + 1)*(limit + 1)*limit)/6;
		System.out.println((sum*sum) - sum_sq);
		
	}

}
