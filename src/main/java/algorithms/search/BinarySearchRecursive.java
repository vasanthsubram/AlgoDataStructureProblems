package algorithms.search;

import static org.junit.Assert.assertTrue;

/**
 * Created by vasanthakumarsubramanian on 12/31/16.
 */
public class BinarySearchRecursive {

    public static void main(String[] args) {

        int[] input = {100, 200, 300, 400, 500, 600};

        assertTrue(search(input, 100) == 0);
        assertTrue(search(input, 500) == 4);
        assertTrue(search(input, 600) == 5);
        assertTrue(search(input, 34500) == -1);
    }

    /**
     * Return the position of the target in the input array
     * If the target is not present, return -1
     */

    public static int search(int[] input, int target){
        return _search_recursive(input, target, 0, input.length-1);
    }

    public static int _search_recursive(int[] input, int target, int min, int max){
        if(min > max){
            return -1;
        }
        int mid = (min + max) / 2;

        if (input[mid] == target) {
            return mid;
        }

        if (input[mid] < target) {
            min = mid + 1;
        } else {
            max = mid - 1;
        }
        return _search_recursive(input, target, min, max);
    }

}
