package algorithms.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String args[]) {
        int[] test = {8, 2, 4, 9, 3, 1, 5, 7, 6, 0};
        new ShellSort().sort(test);
    }

    public void sort(int[] a) {
        int  i, j;
        int N = a.length;

        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ... 
        int h = 1;
        while (h < N/3) {
        	h = 3*h + 1; 
        }
        System.out.println("h= "+h);
        while (h >= 1) {
        	System.out.println("h= "+h);
        	for (i = 0; i < a.length; i++) {
        		for (j=i; j>0; j=j-h) {
        			if(a[j] < a[j-1]){
        				SortUtil.swap(a,j,j-1);
        			} else{
        				break;
        			}
        			System.out.println(Arrays.toString(a));
        		}
        		System.out.println();
        	}
        	h = h/3;
        }
    }
}
