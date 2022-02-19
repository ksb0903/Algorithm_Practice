package im참고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2567 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] paper;
	static int N;
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		paper = new int[101][101];
		int res = 0;
		int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int r=x; r<x+10; r++) {
				for(int c=y; c<y+10; c++) {
					paper[r][c]=1;
				}
			}
		}
		
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				for(int d=0; d<4; d++) {
					int nx = i+deltas[d][0];
					int ny = j+deltas[d][1];
					
					if(paper[i][j]==1) {
						if(nx<0||ny<0||nx>100||ny>100||paper[nx][ny]==0) res++;
					}
				}
			}
		}
		System.out.println(res);
	}
	
}
