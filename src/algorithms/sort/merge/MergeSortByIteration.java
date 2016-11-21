package algorithms.sort.merge;

import java.util.Arrays;

/**
 * NlgN 
 * Needs twice the space
 * 
 * @author subramav
 *
 */
public class MergeSortByIteration {
	
	public static void sort(Comparable[] a){
		int N = a.length;
		Comparable[] aux = new Comparable[N];
		for (int sz = 1; sz < N; sz = sz+sz)			// this loops gets executed lgN times
		for (int lo = 0; lo < N-sz; lo += sz+sz)
		merge(a, aux, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
	}
	
	/**
	 * Given two sorted subarrays a[lo] to a[mid] and a[mid+1] to a[hi], 
	 * replace with sorted subarray a[lo] to a[hi]
	 */
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		/*
		 	i starts at the beginning of the first sorted half, and j at the beginning of second half
		 	k starts at the beginning of the sorted array (what will be a sorted array)
		 	for each k (from lo to hi), put the lower of element at i and j, at k.
		 	if element in i is lower, increment i, otherwise increment j
		 	
		 */
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++){
			if (i > mid) 					a[k] = aux[j++];	//simply copy the second half into the result
			else if (j > hi) 				a[k] = aux[i++];	// simply copy the first half into the result
			else if (less(aux[j], aux[i])) 	a[k] = aux[j++];	
			else 							a[k] = aux[i++];
		}
		System.out.println("Merge " + lo + " , " + mid + "," + hi + "\t\t"+ Arrays.toString(a));
	}
	
	private static boolean less(Comparable v, Comparable w){ 
		return v.compareTo(w) < 0; 
	}
	
	public static void main(String[] args) {
		String[] orig = new String[]{"H", "B", "W", "E", "M", "G", "I", "R", "V", "A" };
		sort(orig);
		System.out.println(Arrays.toString(orig));
	}
}
