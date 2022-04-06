package day11_DP;

import java.util.Scanner;

public class Coin {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int[] dp = new int[money+1];
		dp[0] = 0;
		for(int i=1; i<=money; i++) {
			// 동전은 1, 4, 6원 짜리 존재
			int min = Integer.MAX_VALUE;
			if(i>=1 && dp[i-1]+1<min) min = dp[i-1]+1;
			if(i>=4 && dp[i-4]+1<min) min = dp[i-4]+1;
			if(i>=6 && dp[i-6]+1<min) min = dp[i-6]+1;
			
			dp[i] = min;
		}
		
		System.out.println(dp[money]);
	}
}
