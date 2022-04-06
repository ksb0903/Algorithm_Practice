package day11_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17136 {
	static int min = Integer.MAX_VALUE;
	static int[][] map = new int[10][10];
	static int[] paper = {0, 5, 5, 5, 5, 5};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0; i<10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(0, 0, 0);
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
	}
	
	public static void solve(int x, int y, int cnt) {
		if(min<=cnt) return;
		
		if(x==9 && y==10) {
			min = Math.min(min, cnt);
			return;
		}
		
		if(y==10) {
			solve(x+1, 0, cnt);
			return;
		}
		
		if(map[x][y]==1) {
			for(int i=5; i>=0; i--) {
				if(paper[i]!=0 && check(x, y, i)) {
					cover(x, y, i, 0);
					paper[i]--;
					solve(x, y+1, cnt+1);
					cover(x, y, i, 1);
					paper[i]++;
				}
			}
		}else {
			solve(x, y+1, cnt);
		}
	}
	
	public static void cover(int x, int y, int size, int c) {
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				map[i][j] = c;
			}
		}
	}
	
	public static boolean check(int x, int y, int size) {
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(i>9 || j>9 || map[i][j]==0) return false;
			}
		}
		
		return true;
	}
}
