package algorithms.arrays;

//Sum the number in the array.
//Calculate sum by formula. The diff is the answer

public class FindMissingElementWithMathFormula {
    public static void main(String[] args) {
        // Example input sequence: [1, 2, 3, 4, 6, 7, 8]
        int[] sequence = {1, 2, 3, 4, 6, 7, 8};

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
        long actualSum = 0;

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
            actualSum += num;
        }

        // Check if the sequence is complete (no missing number)
        if (maxValue - minValue + 1 == sequence.length) {
            throw new IllegalArgumentException("No missing integer in the sequence");
        }

        // Calculate the expected sum of the complete sequence [minValue, maxValue]
        long expectedSum = ((long)(maxValue - minValue + 1) * (minValue + maxValue)) / 2;

        // The missing number is the difference between expected and actual sums
        return (int)(expectedSum - actualSum);
    }
}