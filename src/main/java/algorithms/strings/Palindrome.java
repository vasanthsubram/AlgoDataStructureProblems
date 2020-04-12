package algorithms.strings;

/**
 *
 * Created by vasanthakumarsubramanian on 1/7/17.
 */
public class Palindrome {
    public static void main(String[] args) {
//        String s= "Able was I ere I saw Elba";
//        String s = "A Santa at Nasa";
//        String s ="Amore, Roma.";
        String s= "A man, a plan, a cat, a ham, a yak, a yam, a hat, a canal-Panama!";

        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z]+", "");
        System.out.println(s);
        for (int i = 0, j = s.length () - 1; i < j; i++, j--) {
            if (s.charAt(i)!= s.charAt(j)) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }
}
