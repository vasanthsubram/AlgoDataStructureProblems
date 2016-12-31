package algorithms.search;

import static org.junit.Assert.assertTrue;

public class BinarySearch {

    public static void main(String[] args) {
        
    	int[] input = {100, 200, 300, 400, 500, 600};
        
        assertTrue(search(input, 100) == 0);
        assertTrue(search(input, 200) == 1);
        assertTrue(search(input, 600) == 5);
        assertTrue(search(input, 5500) == -1);
    }

    /**
     * Return the position of the target in the input array
     * If the target is not present, return -1
     */
    public static int search(int[] input, int target) {
        int min = 0, max = input.length - 1;
        int result = -1;

        while (max >= min) {
            int mid = (min + max) / 2;
            if (input[mid] == target) {
                result = mid;
                break;
            }
            if (input[mid] < target) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return result;
    }
}
