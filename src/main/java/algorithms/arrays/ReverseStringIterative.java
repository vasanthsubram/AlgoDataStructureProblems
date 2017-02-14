package algorithms.arrays;

/**
 * Reverse string in-place
 *
 * Created by vasanthakumarsubramanian on 1/13/17.
 */
public class ReverseStringIterative {
    public static void main(String[] args) {
//        String input = "able was i ere i saw elba";
        String input="Algorithms";
        char[] charArray= input.toCharArray();
        int length=charArray.length;
        for(int i=0;i<length/2;i++){
            char temp=charArray[i];
            charArray[i]=charArray[length-i-1];
            charArray[length-i-1]=temp;
        }
        System.out.println(new String(charArray));
    }
}
