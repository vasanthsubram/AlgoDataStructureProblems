package algorithms.sort.merge;

import java.util.Arrays;

/**
 * NlgN 
 * Needs twice the space
 * 
 * @author subramav
 *
 */
public class MergeSort {

	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
		System.out.println(lo + " , " + hi);
		if(hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		merge(a, aux, lo, mid, hi);
	}
	
	/**
	 * Given two sorted subarrays a[lo] to a[mid] and a[mid+1] to a[hi], 
	 * replace with sorted subarray a[lo] to a[hi]
	 */
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
	
		//copy the sorted sub arrays into the aux array
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		
		/*
		 	i starts at the beginning of the first sorted half, and j at the beginning of second half
		 	k starts at the beginning of the sorted array (what will be a sorted array)
		 	for each k (from lo to hi), put the lower of element at i and j, at k.
		 	if element in i is lower, increment i, otherwise increment j
		 	lo        mi      hi
		 	# # # # # # # # # # 
		 	i            j
		 	
		 	? ? ? ? ? ? ? ? ? ? 
		 	k
		 */
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++){
			if (i > mid) 					a[k] = aux[j++];	// copy the second half into the result
			else if (j > hi) 				a[k] = aux[i++];	// copy the first half into the result
			else if (less(aux[j], aux[i])) 	a[k] = aux[j++];	
			else 							a[k] = aux[i++];
		}
		System.out.println("Merge " + lo + " , " + mid + "," + hi + "\t\t"+ Arrays.toString(a));
	}
	
	private static boolean less(Comparable v, Comparable w){ 
		return v.compareTo(w) < 0; 
	}
	
	public static void main(String[] args) {
		String[] input = new String[]{"H", "B", "W", "E", "M", "G", "I", "R", "V", "A" };
		Comparable[] aux = new Comparable[input.length];
		sort(input, aux, 0, input.length-1);
		System.out.println("Sorted array" + Arrays.toString(input));
	}
}
