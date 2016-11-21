package algorithms.sort;

import java.util.Arrays;

/*
 * Input array is imaginary divided into two parts - sorted one  and unsorted one. 
 * At the beginning, sorted part contains first element of the array and 
 * unsorted one contains the rest. 
 * At every step, algorithm takes first element in the unsorted part and 
 * inserts it to the right place of the sorted one. 
 * 
 * For randomly ordered arrays of length N with with distinct keys, 
 * insertion sort uses ~N2/4 compares and ~N2/4 exchanges on the average. 
 * 
 * The worst case compares and ~ N2/2 exchanges 
 * The best case is N-1 compares and 0 exchanges.
 */
public class InsertionSort {

    public static void main(String args[]) {
//        int[] test = {9,8,6,7,3,5,4,1,2};
    	int[] test = {1,2,3,4,5,6};
        new InsertionSort().sort(test);
        SortUtil.isSorted(test);
    }
    
   
    public void sort(int[] input) {
        int  i, j;
        //elements to the left of i are sorted
        //elements to the right of i have not been visited
        for (i = 0; i < input.length; i++) {
        	// the j loop inserts the ith element in its correct place in the sorted array
            for (j=i; j>0; j--) { 
            	if(input[j] < input[j-1]){
            		SortUtil.swap(input,j,j-1);
            	} else{
            		// as soon as the element is in place, break
            		break;
            	}
            	System.out.println(Arrays.toString(input));
            }
            System.out.println();
        }
    }
}
