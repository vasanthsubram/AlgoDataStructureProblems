package algorithms.projectEuler;


/*
 	If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
 	The sum of these multiples is 23.

	Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class MultiplesOf3And5 {

	static long MAX=1_000_000_000L;
	
	public static void main(String[] args) {	
		System.out.println("Brute Force");
		bruteForce();
		System.out.println();
		System.out.println("Smart way");
		smartWay();		
	}
	
	static void bruteForce(){
		long sum=0;
		long start = System.currentTimeMillis();
		for(long i=0;i<MAX;i++){
			if(i%3==0 || i%5==0)
			sum+=i;
		}
		long end=System.currentTimeMillis();
		System.out.println("Timt taken = " + (end-start));
		System.out.println("sum = " + sum);
	}
 
	//sum (multiples of 3) + sum(multiples of 5) - (sum of multiples of 15)
	static void smartWay(){
	 long start = System.currentTimeMillis();
		long num3x = MAX/3;
		if(MAX%3==0) num3x--;
		long sumOf3x = 3* sumOfNum(num3x);
		
		long num5x = MAX/5;
		if(MAX%5==0) num5x--;
		long sumOf5x = 5* sumOfNum(num5x);
		
		long num15x = MAX/15;
		if(MAX%15==0) num15x--;
		long sumOf15x = 15* sumOfNum(num15x);
		long end=System.currentTimeMillis();
		System.out.println("Timt taken = " + (end-start));
		System.out.println(sumOf3x + sumOf5x-sumOf15x);
 }
	static long sumOfNum(long upto){
//		System.out.println("Calculating sum of num upto " + upto);
		return upto*(upto+1)/2;
	}
}
