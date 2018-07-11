package algorithms.arrays;

import java.util.Arrays;

/**
 * Created by vasanthakumarsubramanian on 1/13/17.
 */
public class ReverseArrayInPlace {

    public static void main(String[] args){
        reverse(new int[]{1,2,3,4,5});  //odd number of elements
        reverse(new int[]{1,2,3,4});    //even number of elements
        reverse(new int[]{});
    }

    private static void reverse(int[] a){
        int len =  a.length;

        for(int i=0,j=len-1;i<len/2;i++,j--){
            int temp = a[j];
            a[j] = a[i];
            a[i] = temp;
        }
        System.out.println(Arrays.toString(a));
    }
}
