package day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Hamburger_DP {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] arr, dp;
	static int max;
	static int T, N, L;
	
	public static void main(String[] args) throws IOException{
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			arr = new int[N+1][2];
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			max=0;
			dp = new int[N+1][L+1];
			
			getDP();
			bw.write(String.format("#%d ", tc));
			bw.write(dp[N][L]+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void getDP() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=L; j++) {
				if(arr[i][1]>j) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i][1]] + arr[i][0]);
				}
			}
		}
	}
}
