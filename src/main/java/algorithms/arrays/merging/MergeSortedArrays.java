package algorithms.arrays.merging;

import java.util.Arrays;

/**
 * Created by vasanth on 3/25/17.
 */
public class MergeSortedArrays {
    /*
        Given two sorted int arrays- a and b.
        The arrays can have negative numbers
        Array a contains enough space to include array b.
        The number of elements in a is also given.
        Merge b into a.
     */
    public static void main(String[] args) {

        int[] a = new int[10]; // 2,9,10,-,-,-,-,-,-,-
        a[0]=2;
        a[1]=9;
        a[2]=10;
        int len = 3;

        int[] b = new int[]{5,7,8};

        //the key idea is to do the merge from back of a and b into back of a
        int t= (len + b.length)-1;
        int i=len-1;
        for(int j=b.length-1;j>=0;j--){
            if(a[i] >= b[j]){
                a[t] = a[i];
                i--;
                j++;
            } else{
                a[t] = b[j];
            }
            t--;
        }
        System.out.println(Arrays.toString(a));
    }
}
