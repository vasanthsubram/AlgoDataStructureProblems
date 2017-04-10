package algorithms.arrays;

import java.util.Arrays;

/**
 * Created by vasanth on 3/25/17.
 */
public class MergeSortedArrays {

    /*
        Given two sorted int arrays- a and b.
        The arrays can have negative numbers
        One array a contains enough space to include the other array b.
        The number of elements in a is also given.
        Merge b into a.
     */



    public static void main(String[] args) {

        //a has empty slots in it and elemenets from b can be put in it
        int[] a = new int[10]; // 2,9,10,-,-,-,-,-,-,-
        a[0]=2;
        a[1]=9;
        a[2]=10;
        int count =3; //no of elements in a

        int[] b = new int[]{5,7,8};

        //the key idea is to do the merge from back of a and b into back of a
        int total= (count + b.length)-1;
        int aIndex=count-1;
        for(int bIndex=b.length-1;bIndex>=0;bIndex--){
            if(a[aIndex]>=b[bIndex]){
                a[total]=a[aIndex];
                aIndex--;
                bIndex++;
            } else{
                a[total]=b[bIndex];
            }
            total--;
        }
        System.out.println(Arrays.toString(a));
        //2,5,7,8,9,10
    }
}
