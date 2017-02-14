package algorithms.strings;

/**
 * TODO Not done yet
 *
 * Created by vasanthakumarsubramanian on 1/7/17.
 */
public class Palindrome {
    public static void main(String[] args) {
        String s= "Able was I ere I saw Elba";

        for (int i = 0, j = s.length () - 1; i < j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }
}
