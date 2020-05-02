package algorithms.arrays.addToX;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Find two numbers that add upto k
No negative numbers
 */
public class TwoElementsWhoseSumIsK {
    public static void main(String args[]) {

        int[] a = new int[]{2, 3, 5, 5, 1, 9,10, 20, 21, 3, 35, 45};

        find(a,65);
        find(a, 47);
        find(a ,0);
        find(a , 45);
        find(a,80);
        find(a,30);

        System.out.println();

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
        Arrays.sort(a);
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


    private static void find_hash(int[] a, int t){

        Set<Integer> set = new HashSet<>();
        for(int i=0;i<a.length;i++){
            set.add(a[i]);
        }

        for(int i=0;i<a.length;i++) {
            int diff = Math.abs(a[i] - t);
            if(set.contains(diff) && (diff != a[i])){
                System.out.println(a[i]  + "  " +diff);
                return;
            }
        }
        System.out.println("No such pair");
    }


















//    private static void find_hash2(int[] a, int k){
//        Set<Integer> set = new HashSet<>();
//        for(int i=0;i<a.length;i++){
//            set.add(a[i]);
//        }
//        for(int i=0;i<a.length;i++){
//            int key = Math.abs(a[i] - k);
//            if(set.contains(key)){
//                if(key==a[i]){
//                    continue;
//                }
//                System.out.println(a[i] + " " + key);
//                return;
//            }
//        }
//        System.out.println("No such pair");
//    }



}
