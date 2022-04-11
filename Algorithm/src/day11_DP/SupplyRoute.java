package day11_DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class SupplyRoute {
	static int N, map[][], dp[][];
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dp = new int[N][N];
			for(int i=0; i<N; i++) {
				String s = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = (int)s.charAt(j)-'0';
					dp[i][j] = 1000000;
				}
			}
			
			solve();
			bw.write(String.format("#%d ", tc));
			bw.write(dp[N-1][N-1] + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void solve() {
		Queue<int[]> q = new LinkedList<int[]>();
		dp[0][0] = 0;
		q.offer(new int[] {0, 0});
		
		while(!q.isEmpty()) {
			int point[] = q.poll();
			int x = point[0];
			int y = point[1];
			
			for(int d=0; d<4; d++) {
				int nx = x + deltas[d][0];
				int ny = y + deltas[d][1];
				
				if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
				
				if(dp[nx][ny]>(map[nx][ny] + dp[x][y])) {
					dp[nx][ny] = map[nx][ny] + dp[x][y];
					q.offer(new int[] {nx, ny});
				}
			}
		}
	}
}
