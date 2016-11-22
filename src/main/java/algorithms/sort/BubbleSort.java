package algorithms.sort;

import java.util.Arrays;

/**
 * Bubble sort has worst-case and average complexity both О(n2)
 * 
 * @author cuttle-fish
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] test = {1,2,3,4,5};
        new BubbleSort().sort(test);
        System.out.println(Arrays.toString(test));
        SortUtil.isSorted(test);
    }

    public void sort(int[] input) {
    	boolean flag=false;
    	int len = input.length;
        for (int i = 0; i < len; i++) {	
            for (int j = 1; j < len-i; j++) {
                if (input[j] < input[j-1]) {
                	SortUtil.swap(input,j,j-1);
                	flag=true;
                }
                System.out.println(Arrays.toString(input));
            }
            System.out.println();
            if(!flag) {
            	break;
            }
        }
    }
}
