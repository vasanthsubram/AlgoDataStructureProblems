package algorithms.sort.merge;

import java.util.Arrays;

public class MergeSort_RawCode {

	public static void main(String[] args) {

		String[] input = new String[]{ "H", "E", "L", "L", "O", "W", "O", "R", "L", "D"};
		String[] temp = new String[input.length];
		sort(input,temp,0,input.length-1);
		System.out.println(Arrays.toString(input));
	}

	private static void sort(String[] input, String[] temp, int lo, int hi) {
		if(lo>=hi){
			return;
		}
		int mid = lo+(hi-lo)/2;
		sort(input, temp, lo, mid);
		sort(input, temp, mid+1, hi);
		merge(input,temp,lo,mid,hi);
		System.out.println(Arrays.toString(input));
	}
	
	private static void merge(String[] a, String[] temp, int lo, int mid,int hi){
		for (int k = lo; k <= hi; k++)
			temp[k] = a[k];
		int i=lo;
		int j = mid+1;
		
		for(int k=lo;k<=hi;k++){
			if(i > mid)	  								a[k]=temp[j++];
			else if(j>hi) 								a[k]=temp[i++];
			else if(temp[i].compareTo(temp[j]) < 0 ) 	a[k]=temp[i++];
			else 							    		a[k]=temp[j++];
		}
	}
}
