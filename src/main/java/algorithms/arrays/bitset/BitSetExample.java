package algorithms.arrays.bitset;

/**
 * Created by vasanth on 4/7/17.
 */
import java.util.BitSet;

public class BitSetExample {
    public static void main(String[] args) {

        // Set two bits in a BitSet.
        BitSet b = new BitSet();
        b.set(0);
        b.set(1);
        b.set(2);

        // Get values of these bit positions.
        boolean bit1 = b.get(1);
        boolean bit2 = b.get(2);
        boolean bit3 = b.get(100);

        System.out.println(bit1);
        System.out.println(bit2);
        System.out.println(bit3);

        // print the backing bytes
        for (byte value : b.toByteArray()) {
            System.out.println(value);
        }
    }
}
