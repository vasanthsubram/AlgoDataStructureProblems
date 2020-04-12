package algorithms.arrays.merging;

import java.util.Arrays;

public class MergeSortedArraysIntoAnother {

  public static void main(String[] args) {

      int[] arr1 = {1,2,3,20,21,22};
      int[] arr2 = {5,6,7,30,31};
      int total = arr1.length+arr2.length;

      int[] result = new int[total];
      int i,a,b;
      for(i=0,a=0,b=0;i<result.length & a<arr1.length & b<arr2.length;i++){
        if(arr1[a] < arr2[b]){
          result[i] = arr1[a];
          a++;
        } else{
          result[i]= arr2[b];
          b++;
        }
      }

      for(; a<arr1.length;a++){
        result[i]=arr1[a];
        i++;
      }

      for(; b<arr2.length;b++){
        result[i]=arr2[b];
        i++;
      }
      System.out.println(Arrays.toString(result));
  }
}
