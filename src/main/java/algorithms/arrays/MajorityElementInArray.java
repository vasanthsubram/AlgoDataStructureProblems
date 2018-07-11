package algorithms.arrays;

/**
 * Created by vasanth on 3/31/17.
 */
public class MajorityElementInArray {

    public static void main(String[] args) {

        int[] a = {1, 3,4, 3,5, 6,3, 3,7, 3,8, 3,9, 5};
        int maj_index = 0, count = 1;

        for (int i = 1; i < a.length; i++) {
            if (a[maj_index] == a[i])
                count++;
            else
                count--;


            if (count == 0) {
                maj_index = i;
                count = 1;
            }
            System.out.println(count);
        }
        System.out.println("Majority element = " +a[maj_index]);
    }
}