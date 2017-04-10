package algorithms.arrays;

import java.util.Arrays;

/**
 * Created by vasanthakumarsubramanian on 1/13/17.
 */
public class ReverseArray {

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int full = input.length;
        int half = full / 2;

        for (int i = 0, j = full - 1; i < half; i++, j--) {
            int temp = input[i];
            input[i] = input[j];
            input[j] = temp;
        }
        System.out.println(Arrays.toString(input));
    }
}
