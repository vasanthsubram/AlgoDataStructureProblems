package algorithms.arrays.addToX;

import java.util.Arrays;
import java.util.HashMap;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class IndexOfTwoElementsAddingToK {

  public static void main(String[] args) {

//    int[] input = new int[]{3, 4, 11, 15,3};
//    int target = 6;
    int target = 7;
    int[] input = new int[]{3, -4, 11, 15,3};
    int[] result = twoSum(input, target);
    System.out.println(Arrays.toString(result));
  }
  static  public int[] twoSum(int[] nums, int target) {
      HashMap<Integer,Integer> map=new HashMap<>();
      int[] ans=new int[2];
      for(int i=0;i<nums.length;i++){
        int nt=target-nums[i];
        if(map.containsKey(nt)){
          ans[0]=map.get(nt);
          ans[1]=i;
          return ans;
        }
        map.put(nums[i],i);
      }
      return ans;
    }
}
