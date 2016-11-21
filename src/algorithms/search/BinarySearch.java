package algorithms.search;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class BinarySearch {

    public static void main(String[] args) {
        
    	int[] input = {100, 200, 300, 400, 500, 600};
        
        assertTrue(search(input, 100) == 0);
        assertTrue(search(input, 200) == 1);
        assertTrue(search(input, 300) == 2);
        assertTrue(search(input, 400) == 3);
        assertTrue(search(input, 500) == 4);
        assertTrue(search(input, 600) == 5);
        assertTrue(search(input, 5500) == -1);
        
        assertTrue(search_R(input, 100,0,input.length-1) == 0);
        assertTrue(search_R(input, 200,0,input.length-1) == 1);
        assertTrue(search_R(input, 300,0,input.length-1) == 2);
        
        assertTrue(search_R(input, 400,0,input.length-1) == 3);
        assertTrue(search_R(input, 500,0,input.length-1) == 4);
        assertTrue(search_R(input, 600,0,input.length-1) == 5);
        
        assertTrue(search_R(input, 34500,0,input.length-1) == -1);
        
    }

    /**
     * Return the position of the target in the input array
     * If the target is not present, return -1
     * 
     * @param input
     * @param target
     * @return
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
            	//the target is in the second half
                min = mid + 1;
            } else {
            	//the target is in the first half
                max = mid - 1;
            }
        }
        return result;
    }
    
    public static int search_R(int[] input, int target, int min, int max){
    	if(min > max){
    		return -1;
    	}
    	 int mid = (min + max) / 2;
      
    	 if (input[mid] == target) {
             return mid;
         }
        
         if (input[mid] < target) {
         	//the target is in the second half
             min = mid + 1;    
         } else {
        	//the target is in the first half
             max = mid - 1;
         }
         
         return search_R(input, target, min, max);
    }
}
