package algorithms.subarray;

/**
 * Created by vasanthakumarsubramanian on 1/14/17.
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] A = new int[]{ -1, -4, 4,-5, 4,9};
        int newsum=A[0];
        int max=A[0];
        for(int i=1;i<A.length;i++){
            newsum=Math.max(newsum+A[i],A[i]);
            max= Math.max(max, newsum);
        }
        System.out.println(max);
    }
}
