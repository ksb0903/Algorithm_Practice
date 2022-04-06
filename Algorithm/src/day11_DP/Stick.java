package day11_DP;

import java.util.Scanner;

public class Stick {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(solve(n));
		sc.close();
	}
	
	public static int solve(int n) {
		int dp[] = new int[100];
		dp[1] = 2;
		dp[2] = 5;
		
		for(int i=3; i<=n; i++) {
			dp[i] = dp[i-2] + dp[i-1]*2;
		}
		
		return dp[n];
	}
}
