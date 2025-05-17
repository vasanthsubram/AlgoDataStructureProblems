package algorithms.arrays;

import java.util.BitSet;

/**
 * Created by vasanth on 4/7/17.
 */

public class FindMissingIntegerBitSet {
    public static void main(String[] args) {
        // Example input sequence: [1, 2, 3, 4, 6, 7, 8]
        int[] sequence = {101, 102, 103, 104, 106, 107, 108};

        // Find and print the missing integer
        try {
            int missing = findMissingInteger(sequence);
            System.out.println("Missing integer: " + missing);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static int findMissingInteger(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            throw new IllegalArgumentException("Sequence cannot be null or empty");
        }

        // Find the minimum and maximum values in the sequence
        int minValue = sequence[0];
        int maxValue = sequence[0];
        for (int num : sequence) {
            if (num < 1) {
                throw new IllegalArgumentException("Sequence contains invalid number: " + num);
            }
            if (num < minValue) {
                minValue = num;
            }
            if (num > maxValue) {
                maxValue = num;
            }
        }

        // Check if the sequence is complete (no missing number)
        if (maxValue - minValue + 1 == sequence.length) {
            throw new IllegalArgumentException("No missing integer in the sequence");
        }

        // Create a BitSet to mark present integers
        BitSet bitSet = new BitSet(maxValue + 1);

        // Mark each integer in the sequence as present
        for (int num : sequence) {
            bitSet.set(num);
        }

        // Find the first missing integer in the range [minValue, maxValue]
        for (int i = minValue; i <= maxValue; i++) {
            if (!bitSet.get(i)) {
                return i; // Return the first unset bit (missing integer)
            }
        }

        // If no missing integer is found, throw an exception
        throw new IllegalArgumentException("No missing integer found in the sequence");
    }
}