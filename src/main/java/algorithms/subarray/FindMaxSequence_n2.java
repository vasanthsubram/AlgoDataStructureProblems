package algorithms.subarray;

import java.util.ArrayList;
import java.util.List;

/**
 * In a given array of integers, find the sequence of integers which add up to a maximum value
 * The array could contain negative numbers
 *
 * Created by vasanth on 12/12/16.
 */
public class FindMaxSequence_n2 {

    public static void main(String[] args){
        int[] arr = {-1, 7, -2, 14, -20, 18, -34, 56};
        List list =findSeq(arr);
        System.out.println(list);
    }

    public static List findSeq(int[] arr){
        int sum[][]=new int[arr.length][arr.length];
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int prev = (j-1)<0?0:j-1;
                sum[i][j]=sum[i][prev]+ arr[j];
            }
        }

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++) {
                System.out.print(sum[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }

        int maxi=0, maxj=0;
        int max=sum[0][0];
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                if(sum[i][j]>max){
                    max=sum[i][j];
                    maxi=i;
                    maxj=j;
                }
            }
        }
        ArrayList list = new ArrayList();
        for(int x=maxi;x<=maxj;x++){
            list.add(arr[x]);
        }
        return list;
    }
}