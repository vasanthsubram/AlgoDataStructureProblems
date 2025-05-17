package algorithms.dynamic.lcs;

public class LCSVisual {

    public static String lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];
        char[][] backtrack = new char[m + 1][n + 1]; // 'D': diagonal, 'U': up, 'L': left

        // Build the dp table and backtrack table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    backtrack[i][j] = 'D'; // Diagonal
                } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j];
                    backtrack[i][j] = 'U'; // Up
                } else {
                    dp[i][j] = dp[i][j - 1];
                    backtrack[i][j] = 'L'; // Left
                }
                printTable(dp, i, j); //Print after each iteration
                printBacktrack(backtrack, i,j);
            }
        }

        // Reconstruct the LCS
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (backtrack[i][j] == 'D') {
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (backtrack[i][j] == 'U') {
                i--;
            } else {
                j--;
            }
        }

        return lcs.reverse().toString();
    }

    public static void printTable(int[][] dp, int currentRow, int currentCol) {
        System.out.println("DP Table (Current cell: [" + currentRow + ", " + currentCol + "])");
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.printf("%4d", dp[i][j]);
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }

    public static void printBacktrack(char[][] backtrack, int currentRow, int currentCol){
        System.out.println("Backtrack Table (Current cell: [" + currentRow + ", " + currentCol + "])");
        for (int i = 0; i < backtrack.length; i++) {
            for (int j = 0; j < backtrack[0].length; j++) {
                System.out.printf("%4c", backtrack[i][j]);
            }
            System.out.println();
        }
        System.out.println("-------------------------");

    }

    public static void main(String[] args) {
        String s1 = "ABC";  //6
        String s2 = "AC"; //7
        String result = lcs(s1, s2);
        System.out.println("LCS: " + result);
    }
}