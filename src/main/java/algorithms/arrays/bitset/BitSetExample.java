package algorithms.arrays.bitset;

/**
 * Created by vasanth on 4/7/17.
 */
import java.util.BitSet;

public class BitSetExample {
    public static void main(String[] args) {

        // Set two bits in a BitSet.
        BitSet b = new BitSet(100);
        b.set(0);
        b.set(1);
        b.set(2);
        b.set(99);
        // Get values of these bit positions.
        boolean bit0 = b.get(0);
        boolean bit1 = b.get(1);
        boolean bit2 = b.get(2);
        boolean bit3 = b.get(99);

        System.out.println(bit0);
        System.out.println(bit1);
        System.out.println(bit2);
        System.out.println(bit3);

        // print the backing bytes
        int sum=0;
        for (byte value : b.toByteArray()) {
            System.out.println(value);
        }
    }
}
