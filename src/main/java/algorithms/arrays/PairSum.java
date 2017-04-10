package algorithms.arrays;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

class PairSum {
    private static final int MAX = 100000; // Max size of Hashmap

    static void printpairsUsingBitSet(int arr[],int sum) {
        BitSet bitSet=new BitSet();
        for (int i=0; i<arr.length; ++i) {
            int temp = sum-arr[i];

            // checking for condition
            if (temp>=0 && bitSet.get(temp)) {
                System.out.println("Pair with given sum " + sum + " is (" + arr[i] + ", "+temp+")");
            }
            bitSet.set(arr[i]);
        }
    }

    //can handle negative numbers
    static void printpairsUsingSet(int arr[],int sum) {
        // Declares and initializes the whole array as false

        Set<Integer> set = new HashSet<>();
        for (int i=0; i<arr.length; ++i) {
            int temp = sum-arr[i];

            // checking for condition
            if (temp>=0 && set.contains(temp)) {
                System.out.println("Pair with given sum " + sum + " is (" + arr[i] + ", "+temp+")");
            }
            set.add(arr[i]);
        }
    }

    static void printpairsUsingBooleanArray(int arr[],int sum) {
        // Declares and initializes the whole array as false
        boolean[] binmap = new boolean[MAX];

        for (int i=0; i<arr.length; ++i) {
            int temp = sum-arr[i];

            // checking for condition
            if (temp>=0 && binmap[temp]) {
                System.out.println("Pair with given sum " + sum + " is (" + arr[i] + ", "+temp+")");
            }
            binmap[arr[i]] = true;
        }
    }

    // Main to test the above function
    public static void main (String[] args) {
        int A[] = {1, 4, 45, 6, 10, 8, 12};
        int n = 16;
        printpairsUsingBitSet(A, n);
        printpairsUsingBooleanArray(A,n);

        int B[] = {1, 4, 45, 6, 10, 8, 12,1000,-984};
        printpairsUsingSet(A, n);

    }
}

// This article is contributed by Aakash Hasija
