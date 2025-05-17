package algorithms.dynamic.lcs;

public class LCSRecursive {

    // Recursive method with visual tracing
    public static int lcs(String str1, String str2, int i, int j, String indent) {
        // Print the current state (like a decision tree node)
        System.out.println();
        System.out.println(indent + "LCS(" + i + ", " + j + ")");

        // Base case
        if (i == str1.length()-1 || j == str2.length()-1) {
            System.out.println(indent + "-> return 0");
            return 0;
        }

        if (str1.charAt(i + 1) == str2.charAt(j + 1)) {
            System.out.println(indent + "Match: " + str1.charAt(i + 1) + " at (" + (i+1) + "," + (j+1) +")");
            int result = 1 + lcs(str1, str2, i + 1, j + 1, indent + "  ");
            System.out.println(indent + "-> return " + result);
            return result;
        } else {
            System.out.println(indent + "No match: " + str1.charAt(i + 1) + " vs " + str2.charAt(j + 1)  +
                    str1.charAt(i + 1) + " at (" + (i+1) + "," + (j+1) + ")");
            int left = lcs(str1, str2, i + 1, j, indent + "  ");
            int right = lcs(str1, str2, i, j + 1, indent + "  ");
            int result = Math.max(left, right);
            System.out.println(indent + "-> return max(" + left + ", " + right + ") = " + result);
            return result;
        }
    }

    public static void main(String[] args) {
        String str1 = "CABCD";
        String str2 = "AC";
        System.out.println("LCS for " + str1 + " and " + str2);

        int lcsLength = lcs(str1, str2, -1, -1, "");
        System.out.println("\nLength of LCS: " + lcsLength);
    }

    /*
LCS for ABC and AC
------------------
LCS for ABCD and AC
LCS(-1, -1)
Match: A
  LCS(0, 0)
  No match: B vs C
    LCS(1, 0)
    Match: C
      LCS(2, 1)
      -> return 0
    -> return 1
    LCS(0, 1)
    -> return 0
  -> return max(1, 0) = 1
-> return 2

Length of LCS: 2

     */
}
