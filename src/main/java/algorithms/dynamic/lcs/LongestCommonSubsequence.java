package algorithms.dynamic.lcs;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String a = "GXTXAYB";
        String b = "AGGTAB";

        int[][] lengths = new int[a.length()][b.length()];
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length()+1; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    lengths[i + 1][j + 1] = lengths[i][j] + 1;				//add 1 to value in upper-left cell
                } else {
                    lengths[i + 1][j + 1] = Math.max(lengths[i + 1][j], lengths[i][j + 1]);	  //max of value in left and upper cell
                }
            }
        }

    }
}
