package algorithms;

import java.util.Arrays;

public class SumOfNumbers {

	/**
	 *  Given an array of numbers (+ve , -ve) and a number k, 
	 *  return true if any two numbers sum up to k.
	 *  
	 *  cannot ignore positive number > k - because when added with a negative number could equal to k
	 *  is it sorted. if not, can it be sorted ?
	 *  The number k may not be in the input
	 *  return true if the first pair is found 
	 */
	public static void main(String[] args) {
		int N=10;
		int[] input=new int[N];
		for(int i=0;i<N;i++){
			input[i]=i;
		}
		int k=8;
		detect(k,input);
		
	}

	
	static boolean detect(int k, int[] input){
		int location = Arrays.binarySearch(input, k);
		System.out.println(location);

		for(int i=location;i<input.length;i++){
			for(int j=i;j>=0;j--){
				System.out.println(i + "  "+ j);
				if(input[i]+input[j] > k){
					break;
				}
				if(input[i]+input[j]==k){
					System.out.println(input[i]);
					System.out.println(input[j]);
					return true;
				}
			}
		}
		return false;
	}
}
