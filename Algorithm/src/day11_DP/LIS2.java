package day11_DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LIS2 {
	static int N, arr[], dp[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			dp = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			bw.write(String.format("#%d ", tc));
			bw.write(solve() + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static int solve() {
		int len = 1;
		dp[0] = arr[0];
		
		for(int i=1; i<N; i++) {
			if(dp[len-1]<=arr[i]) {
				dp[len++] = arr[i];
			}else {
				int tmp = Arrays.binarySearch(dp, 0, len, arr[i]);
				if(tmp<0) tmp = -tmp-1;
				dp[tmp] = arr[i];
			}
		}
		
		return len;
	}
}
