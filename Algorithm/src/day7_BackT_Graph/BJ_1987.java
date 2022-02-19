package day7_BackT_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1987 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int R, C, max, deltas[][] = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	static int[][] board;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new int[R][C];
		max = Integer.MIN_VALUE;
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				board[i][j] = str.charAt(j)-'A';
			}
		}
		int v = 1<<board[0][0];
				
		dfs(0, 0, 1, v);
		System.out.println(max);
	}
	
	public static void dfs(int r, int c, int count, int v) {
		max = Math.max(max, count);
		
		for(int d=0; d<4; d++) {
			int nr = r+deltas[d][0];
			int nc = c+deltas[d][1];
			
			if(nr>=0 && nc>=0 && nr<R && nc<C) {
				if((v & (1<<board[nr][nc]))==0) {
					int nv = (v | 1<<board[nr][nc]);
					dfs(nr, nc, count+1, nv);
				}
			}
		}
	}
}
