package algorithms.sort;

public class SortUtil {

	public static void isSorted(int[] a) {
        for (int i = 1; i < a.length; i++)
            if ((a[i] < a[i-1])) {
            	throw new RuntimeException("Error: element " + a[i]+ " is greater than element "+a[i-1]);
            }
    }
	
	public static boolean less(Comparable v, Comparable w){ 
		return v.compareTo(w) < 0; 
	}
	
	 public static void swap(int[] input, int i, int min){
	    	int temp = input[i];
	        input[i] = input[min];
	        input[min] = temp;
	    }
}
