package algorithms.strings;

public class SubSequenceOfString {
  public static void main(String[] args) {

    System.out.println(check("WORLD", "W"));
    System.out.println(check("WORLD", "WORL"));
    System.out.println(check("WORLD", "RLD"));
    System.out.println(check("WORLD", "WORLD"));

    System.out.println();
    System.out.println(check("WORLD", "WDL"));
    System.out.println(check("WORLD", "DPX"));

  }

  //check if s2 is a subsequence of s1
  static boolean check(String s1, String s2) {
    int i = 0, j = 0;

    for (i = 0; i < s2.length() && (j < s1.length()); ) {
      if (s1.charAt(j) == s2.charAt(i)) {
        i++;
      } else {
        j++;
      }
    }
    if (i < s2.length()) {
      return false;
    }
    return true;
  }
}
