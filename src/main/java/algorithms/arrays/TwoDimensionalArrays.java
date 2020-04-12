package algorithms.arrays;

import java.util.Arrays;

public class TwoDimensionalArrays {
    public static void main(String[] args){
        int[][] a = new int[3][9];
        a[1][1]=1;
        a[2][2]=2;
        System.out.println(a.length);       //3
        System.out.println(a[0].length);    //9

        for(int i=0;i<a.length;i++){
            System.out.println(Arrays.toString(a[i]));
        }
    }
}
