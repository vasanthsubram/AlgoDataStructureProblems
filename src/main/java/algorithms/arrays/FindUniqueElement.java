package algorithms.arrays;

import java.util.HashSet;

public class FindUniqueElement {

//  static int[] nums = {1000000000,1000000001, 1000000002, 1000000003, 3,4,4,3,1,1000000000,1000000001, 1000000002, 1000000003,};
  static int[] nums = {1,2, 4, 3,1,2, 3, 4,5};

  public static void main(String[] args) {

    usingXOR();

    usingHashSet();
  }

  //integer could overflow
  static void usingXOR(){
    int a = 0;
    for (int i : nums) {
      a ^= i;
//      System.out.println(a);
    }
    System.out.println(a);
  }

  static void usingHashSet() {
    HashSet<Integer> hashSet = new HashSet<>();
    for(int i=0;i<nums.length;i++){
      int e = nums[i];
      if(hashSet.contains(e)){
        hashSet.remove(e);
      } else{
        hashSet.add(e);
      }
    }
    System.out.println(hashSet);
  }
}
