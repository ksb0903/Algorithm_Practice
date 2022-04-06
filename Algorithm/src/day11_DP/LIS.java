package day11_DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LIS {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] dp = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<N; i++) {
				dp[i] = 1;
				for(int j=0; j<i; j++) {
					if(arr[i]>arr[j] && dp[i]<=dp[j]) {
						dp[i]++;
					}
				}
			}
			
			int max = 0;
			
			for(int i=0; i<N; i++) {
				max = Math.max(max, dp[i]);
			}
			
			bw.write(String.format("#%d ", tc));
			bw.write(max + "\n");
		}
		bw.flush();
		bw.close();
	}
}
