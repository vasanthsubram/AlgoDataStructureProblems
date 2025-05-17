package algorithms.dynamic.lcs;

public class LCSRecursiveWithMemoization {

    // Memoization table
    static int[][] memo;

    // Recursive LCS with memoization
    public static int lcs(String str1, String str2, int i, int j) {
        // Base case
        if (i == 0 || j == 0) return 0;

        // If already calculated, return it
        if (memo[i][j] != -1) return memo[i][j];

        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            // Characters match: move both pointers
            memo[i][j] = 1 + lcs(str1, str2, i - 1, j - 1);
        } else {
            // Characters don't match: explore both options
            memo[i][j] = Math.max(
                    lcs(str1, str2, i - 1, j),
                    lcs(str1, str2, i, j - 1)
            );
        }

        return memo[i][j];
    }

    public static void main(String[] args) {
        String str1 = "ABCBDAB";
        String str2 = "BDCAB";

        int m = str1.length();
        int n = str2.length();

        // Initialize memo table with -1
        memo = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                memo[i][j] = -1;
            }
        }

        int length = lcs(str1, str2, m, n);
        System.out.println("Length of LCS: " + length);
    }
}
