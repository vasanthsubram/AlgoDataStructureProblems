package algorithms.arrays;

/**
 * Reverse string in-place
 * Reverse String without loop or in-built method
 *
 * Created by vasanthakumarsubramanian on 1/13/17.
 */
public class ReverseStringRecursive {
    public static void main(String[] args) {

        String input = "Algorithm";

        char[] inputArray=input.toCharArray();
        new ReverseStringRecursive().reverse(inputArray, 0);
        System.out.println(new String(inputArray));
    }

    private void reverse(char[] input, int index) {
        int len=input.length;
        if(index==len/2){
            return;
        }
        char temp=input[index];
        input[index]=input[len-index-1];
        input[len-index-1]=temp;
        reverse(input, ++index);
    }
}
