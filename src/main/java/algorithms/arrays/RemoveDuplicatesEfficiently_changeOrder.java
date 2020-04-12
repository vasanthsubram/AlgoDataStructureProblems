package algorithms.arrays;

import java.util.Arrays;

public class RemoveDuplicatesEfficiently_changeOrder {

  public static void main(String[] args){
    Integer[] arr = new Integer[]{1,2,1,3,45};

    System.out.println(arr.length);

    Arrays.sort(arr);
    int prev=arr[0];
    int len = arr.length;

    for(int i=1; i<len;i++){
      if(prev==arr[i]){
        arr[i]=arr[arr.length-1];
        arr[arr.length-1]=null;
        len--;
      } else{
        prev = arr[i];
      }
    }
    Integer[] arr2 = new Integer[len];
    System.arraycopy(arr,0,arr2,0, len);
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(arr2));
  }
}
