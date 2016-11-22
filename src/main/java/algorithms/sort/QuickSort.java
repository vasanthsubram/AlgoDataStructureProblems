package algorithms.sort;

import java.util.Arrays;

public class QuickSort {

	public static void sort(Comparable[] a){
//		StdRandom.shuffle(a);
		sort(a,0,a.length-1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi){
		if(hi <= lo){
			return;
		}
		int j= partition(a, lo, hi);
		System.out.println(Arrays.toString(a));
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	
	private static int partition(Comparable[] a, int lo, int hi){
		int i = lo, j = hi + 1;
		while(true){
			while(less(a[++i],a[lo])){
				if(i == hi) { 
					break;
				}
			}
			
			while(less(a[lo], a[--j])){
				if(j == lo){
					break;
				}
			}
			
			if(i >= j) {
				break;
			}
			exch(a,i,j);
		}
		 // put v = a[j] into position
        exch(a, lo, j);
		return j;
	}
	
	private static boolean less(Comparable v, Comparable w){ 
		return v.compareTo(w) < 0; 
	}
	
	private static void exch(Comparable[] a, int i, int j){
		Comparable temp = a[j];
		a[j]=a[i];
		a[i]=temp;
		
	}
	
	public static void main(String[] args) {

		String[] orig = new String[]{"B", "A", "B", "A", "A", "A", "B", "A", "B", "B", "B", "B" };
		sort(orig);
//		System.out.println(Arrays.toString(orig));
	}
}
