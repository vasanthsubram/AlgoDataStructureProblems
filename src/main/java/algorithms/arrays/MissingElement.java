package algorithms.arrays;

import java.util.Arrays;
import java.util.BitSet;

/**
 * Created by vasanth on 4/7/17.
 */
public class MissingElement {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 6, 7, 8};
        printMissingNumber(numbers,10);
    }

    private static void printMissingNumber(int[] numbers, int count) {
        int missingCount = count - numbers.length;
        BitSet bitSet = new BitSet(count);
        for (int number : numbers) {
            bitSet.set(number - 1);
        }
        System.out.println("Missing numbers in integer array :");
        int lastMissingIndex = 0;
        for (int i = 0; i < missingCount; i++) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            lastMissingIndex++;
            System.out.println(lastMissingIndex);
        }
    }

}