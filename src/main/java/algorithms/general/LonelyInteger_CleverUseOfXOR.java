package algorithms.general;

import java.util.Arrays;

/*
 * There are N integers in an array A. 
 * All but one integer occurs in pairs. 
 * Your task is to find out the number that occurs only once.
 * N is odd number
 */
public class LonelyInteger_CleverUseOfXOR {
	static int lonelyInteger(int[] a) {
		Arrays.sort(a);

		int len= a.length;
		for(int i=0;i<len-1;i=i+2){
			/* 
			 * if u consider the array as collection of pairs, 
			 * only the first one in the pair can be target
			 */
			if(a[i] != a[i+1]){
				return a[i];
			}
		}
		//the last element is the target
		return a[len-1];

	}
	
	static int lonelyInteger2(int[] a){
		        int j=0;
		        for(int i=0;i <= a.length-1;i++) {
		        	j=j^a[i];
//		        	 System.out.println(j);
		        }
		        return j;
	}

	public static void main(String[] args) {
		int[] a1 = new int[] { 1, 5, 6, 5, 7, 6, 7, 1290, 1345, 1290,1345};

		int[] a2 = new int[] { 5, 5, 6, 6, 7, 7, 20 };
		
		int[] a3 = new int[] { 5, 5, 6, 7, 7 };
		
		int res = lonelyInteger2(a1);
		System.out.println(res);
		
		int res2 = lonelyInteger2(a2);
		System.out.println(res2);
		
		int res3 = lonelyInteger2(a3);
		System.out.println(res3);

	}
}
