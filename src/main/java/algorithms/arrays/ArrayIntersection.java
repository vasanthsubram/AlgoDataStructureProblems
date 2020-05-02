package main.java.algorithms.arrays;

import java.util.Arrays;
import java.util.HashSet;

public class ArrayIntersection {
  public static void main(String[] args) {
    int[] nums1 = {1,2,2,1}, nums2 = {2,2,4,1};

    HashSet<Integer> hashSet = new HashSet<>();
    HashSet<Integer> result = new HashSet<>();

    int[] bigger = nums2, smaller = nums1;

    if(nums1.length >= nums2.length){
      bigger = nums1;
      smaller = nums2;
    }

    for(int i=0;i<bigger.length;i++){
      hashSet.add(bigger[i]);
    }

    for(int i=0;i<smaller.length;i++){
      if(hashSet.contains(smaller[i])){
        result.add(smaller[i]);
      }
    }
    System.out.println(result);
  }
}
