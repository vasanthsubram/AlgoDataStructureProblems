package algorithms.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You are given coins of different denominations and a total amount of money amount.
Write a function to compute the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.
 */
public class CoinChange_FewestCoins {

	public static void main(String[] args) {

		int coins[]=new int[]{2,3};
		int change=17;

		coinChange(coins,change);

	}

	public static int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);

		int target = amount;
		List coinPattern= new ArrayList();

		for(int i=coins.length-1;i>=0;i--){
			int curr = coins[i];
			int result=target/curr;
			if(result>0){
				for(int j=0;j<result;j++){
					coinPattern.add(curr);
				}
				target=target-(result*curr);
			}
		}

		if(coinPattern.size()>0 &&(target==0)){
			System.out.println("change = " + amount + " ->   " + coinPattern);
			return 1;
		}
		System.out.println("change = " + amount + " ->   cannot give change");
		return -1;
	}
}
