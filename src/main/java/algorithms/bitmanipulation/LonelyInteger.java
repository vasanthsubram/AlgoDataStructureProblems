package algorithms.bitmanipulation;

import java.util.Arrays;

/**
 * There are N integers in an array A.
 * All but one integer occurs in pairs.
 * Your task is to find out the number that occurs only once.
 * N is odd number
 */

public class LonelyInteger {

    static int lonelyInteger(int[] a) {
        Arrays.sort(a);

        int len= a.length;
        for(int i=0;i<len-1;i=i+2){
            //only the first one in the pair, can be that lone integer
            if(a[i] != a[i+1]){
                return a[i];
            }
        }
        //the last element is that lone integer
        return a[len-1];
    }

    public static void main(String[] args) {
        int[] a1 = new int[] { 1, 5, 6, 5, 7, 6, 7, 1290, 1345, 1290,1345};

        System.out.println(lonelyInteger(a1));
    }
}
