package day7_BackT_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3109 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int R, C, count;
	static char[][] map;
	static boolean flag;
	static int[][] deltas = {{-1,1},{0,1},{1,1}};
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().replace(" ", "").toCharArray();
		}
		for(int i=0; i<R; i++) {
			flag = false;
			solve(i, 0);
		}
		System.out.println(count);
	}
	
	public static void solve(int r, int c) {
		map[r][c] = 'x';
		
		if(c==C-1) {
			count++;
			flag = true;
			return;
		}
		
		int idx=0;
		while(idx<3) {
			int nr = r+deltas[idx][0];
			int nc = c+deltas[idx][1];
			
			if(nr>=0 && nc>=0 && nr<R && nc<C) {
				if(map[nr][nc]=='.') {
					solve(nr, nc);
				}
			}
			idx++;
			if(flag) break;
			
		}
		
		
	}
}
