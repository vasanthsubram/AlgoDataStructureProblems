package algorithms.dynamic.lcs;

public class SubsequenceChecker {

    public static boolean isSubsequence(String sub, String str) {
        if (sub.length() == 0) {
            return true; // Empty string is always a subsequence
        }

        int subIndex = 0;
        int strIndex = 0;

        while (strIndex < str.length()) {
            if (sub.charAt(subIndex) == str.charAt(strIndex)) {
                subIndex++;
                if (subIndex == sub.length()) {
                    return true; // Entire subsequence found
                }
            }
            strIndex++;
        }

        return false; // Subsequence not found
    }

    public static void main(String[] args) {
        String str = "abcde";
        String sub1 = "ace";
        String sub2 = "aec";
        String sub3 = "";
        String sub4 = "abcde";
        String sub5 = "abx";

        System.out.println("\"" + sub1 + "\" is a subsequence of \"" + str + "\": " + isSubsequence(sub1, str)); // true
        System.out.println("\"" + sub2 + "\" is a subsequence of \"" + str + "\": " + isSubsequence(sub2, str)); // false
        System.out.println("\"" + sub3 + "\" is a subsequence of \"" + str + "\": " + isSubsequence(sub3, str)); // true
        System.out.println("\"" + sub4 + "\" is a subsequence of \"" + str + "\": " + isSubsequence(sub4, str)); // true
        System.out.println("\"" + sub5 + "\" is a subsequence of \"" + str + "\": " + isSubsequence(sub5, str)); // false
    }
}