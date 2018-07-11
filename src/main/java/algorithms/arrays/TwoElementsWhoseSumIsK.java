package algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

/*
Find two numbers that add upto k
No negative numbers
Input array is sorted
 */
public class TwoElementsWhoseSumIsK {
    public static void main(String args[]) {

        int[] a = new int[]{2, 3, 5, 5, 7, 9,10, 20, 21, 25, 35, 45};

        find(a,65);
        find(a, 47);
        find(a ,0);
        find(a , 45);
        find(a,80);
        find(a,30);

        System.out.println();

        find_hash(a,65);
        find_hash(a, 47);
        find_hash(a ,0);
        find_hash(a , 45);
        find_hash(a,80);
        find_hash(a,30);
    }

    private static void find(int[] a, int k){
        int low = 0;
        int high = a.length -1;

        while(low < high){
            int sum = a[low] + a[high];
            if(sum == k) {
                System.out.println(a[low] +  " " + a[high]);
                return;
            }
            if(sum > k){
                high--;
            } else{
                low++;
            }
        }
        System.out.println("No such pair");
    }

    private static void find_hash(int[] a, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<a.length;i++){
            map.put(a[i],a[i]);
        }
        for(int i=0;i<a.length;i++){
            int key = Math.abs(a[i] - k);
            if(map.containsKey(key)){
                System.out.println(a[i] + " " + key);
                return;
            }
        }
        System.out.println("No such pair");
    }
}
