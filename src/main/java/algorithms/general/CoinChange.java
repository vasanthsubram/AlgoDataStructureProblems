package algorithms.general;

import java.util.Scanner;

public class CoinChange {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number of coins");
		int n = sc.nextInt();
		int[] coins = new int[n + 1];
		System.out.println("input the value of each coin");
		for (int i = 1; i <= n; i++)
			coins[i] = sc.nextInt();
		System.out.println("input the amount of change");
		int change = sc.nextInt();
		System.out.printf("there are %d ways to make change for %d cents\n",
				countChange(coins, change), change);
	}

	public static int countChange(int[] coins, int change) {
		int numCoins = coins.length;
		int[][] dp = new int[change + 1][numCoins];
		for (int i = 0; i < numCoins; i++)
			dp[0][i]++;

		for (int i = 1; i <= change; i++) {
			for (int j = 1; j < numCoins; j++) {
				dp[i][j] = dp[i][j - 1];
				if (i - coins[j] >= 0)
					dp[i][j] += dp[i - coins[j]][j];
			}
		}
		return dp[change][numCoins - 1];
	}

}
