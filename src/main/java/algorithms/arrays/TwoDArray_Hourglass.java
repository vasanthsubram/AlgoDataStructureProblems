package algorithms.arrays;

import java.io.IOException;
import java.util.Arrays;

/*
We define an hourglass in an array to be a subset of values with indices falling
in this pattern in 's graphical representation:
a b c
  d
e f g

There are 16  hourglasses in a 6x6 array , and an hourglass sum is the sum of an hourglass' values.
Calculate the hourglass sum for every hourglass in the array , then print the maximum hourglass sum.

 */
public class TwoDArray_Hourglass {

  static int hourglassSum(int[][] arr) {
    int max= sum(arr,1,1);
    for(int i=1;i <= arr.length-2; i++){
      for(int j=1; j<= arr[0].length-2;j++){
        int sum = sum(arr, i,j);
        if(max < sum) max=sum;
      }
    }
    return max;
  }

  static int sum(int[][] arr, int i, int j){
    int sum=arr[i][j];
    for(int m =i-1; m <=i+1;m=m+2){
      for(int n = j-1;n<=j+1;n++){
        sum  = sum + arr[m][n];
//        System.out.println(sum);
      }
    }
    return sum;
  }


  public static void main(String[] args) throws IOException {

    int[][] arr = new int[6][6];
    arr[0]= new int[]{1, 1, 1, 0, 0, 0};

    arr[1]= new int[]{0, 21, 0, 0, 0, 0};
    arr[2]= new int[]{1, 1, 1, 0, 0, 0};
    arr[3]= new int[]{0, 0, 2, 4, 4, 0};
    arr[4]= new int[]{0, 0, 0, 2, 0, 0};
    arr[5]= new int[]{0, 0, 1, 2, 4, 0};

    for(int i=0;i<arr.length;i++) {
      System.out.println(Arrays.toString(arr[i]));
    }
    int result = hourglassSum(arr);
    System.out.println(result);

  }
}

