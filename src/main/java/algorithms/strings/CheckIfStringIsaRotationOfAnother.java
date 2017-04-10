package algorithms.strings;

/**
 * Created by vasanth on 3/30/17.
 */
public class CheckIfStringIsaRotationOfAnother {

    public static void main(String[] args) {
        System.out.println(isRotation("ldgo", "gold"));
        System.out.println(isRotation("dgol", "gold"));
        System.out.println(isRotation("ldog", "gold"));
    }

    static boolean isRotation(String s1,String s2) {
        return (s1.length() == s2.length()) && ((s1+s1).contains(s2));
    }
}
