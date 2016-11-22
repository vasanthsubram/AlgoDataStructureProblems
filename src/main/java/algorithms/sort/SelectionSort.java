package algorithms.sort;

import java.util.Arrays;

/**
 * Selection sort is a sorting algorithm, specifically an in-place comparison sort.
 * It has O(n2) time complexity, making it inefficient on large lists, and generally performs worse than the similar insertion sort
 * 
 * The algorithm works as follows:
 *  Find the minimum value in the list
 *  Swap it with the value in the first position
 *  Repeat the steps above for the remainder of the list (starting at the second position and advancing each time.
 * @author vsubramanian
 */
public class SelectionSort {

     public static void main(String[] args) {
        int[] test = {8, 2, 4, 9, 3,1,6,7,5};
        new SelectionSort().sort(test);
        System.out.println(Arrays.toString(test));
        SortUtil.isSorted(test);
    }

    public void sort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int min = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[min] ) {
                	min = j;
                }
            }
            SortUtil.swap(input, i, min);
        }
    }
}
