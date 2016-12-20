package algorithms.subarray;

/**
 * Created by vasanth on 12/13/16.
 */
// Java program to print largest contiguous array sum

public class FindMaxSequence  {
    public static void main (String[] args) {
        int [] a = {-2, -3, 4, -10, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
    }

    static int maxSubArraySum(int a[]) {
        int size = a.length;
        int max_so_far = 0, max_ending_here = 0;
        int min_so_far = 0, min_ending_here = 0;

        //start and end of the sub array with max sum
        int rangeStart=0, rangeEnd=0;

        for (int i = 0; i < size; i++) {


            max_ending_here = max_ending_here + a[i];
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }

            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                rangeEnd=i;
            }
        }
        System.out.println(rangeStart);
        System.out.println(rangeEnd);
        return max_so_far;
    }
}