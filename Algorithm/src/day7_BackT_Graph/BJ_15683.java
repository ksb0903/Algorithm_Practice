package day7_BackT_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_15683 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, zeroCnt, cctvCnt, min;
	static int[][] map;
	static int[] xy = new int[3];
	static ArrayList<int[]> cctv = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		min = 64;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]!=0 && map[i][j]!=6) {
					cctv.add(new int[] {map[i][j], i, j});
					cctvCnt++;
				}
			}
		}
		cctv.add(new int[] {0,0,0});
		check(0, cctv.get(0)[0], map, cctv.get(0)[1], cctv.get(0)[2]);
		System.out.println(min);
	}
	
	public static void check(int cnt, int cmd, int[][] arr, int x, int y) {
		if(cnt==cctvCnt) {
			min = Math.min(countZero(arr), min);
			return;
		}
		int[][] clone = new int[N][M];
		for(int d=0; d<4; d++) {
			for(int i=0; i<N; i++) {
				clone[i] = arr[i].clone();
			}
			switch(cmd) {
			case 1:
				monitor(x, y, d, clone);
				break;
			case 2:
				monitor(x, y, d, clone);
				monitor(x, y, (d+2)%4, clone);
				break;
			case 3:
				monitor(x, y, d, clone);
				monitor(x, y, (d+1)%4, clone);
				break;
			case 4:
				monitor(x, y, d, clone);
				monitor(x, y, (d+1)%4, clone);
				monitor(x, y, (d+2)%4, clone);
				break;
			case 5:
				monitor(x, y, 0, clone);
				monitor(x, y, 1, clone);
				monitor(x, y, 2, clone);
				monitor(x, y, 3, clone);
				break;
			}
			check(cnt+1, cctv.get(cnt+1)[0], clone, cctv.get(cnt+1)[1], cctv.get(cnt+1)[2]);
		}
	}
	
	public static void monitor(int x, int y, int d, int[][] arr) {
		int deltas[][] = {{0,1},{1,0},{0,-1},{-1,0}};
		int nx = x + deltas[d][0];
		int ny = y + deltas[d][1];
		
		while(true) {
			if(nx<0 || ny<0 || nx>=N || ny>=M || arr[nx][ny]==6) break;
			arr[nx][ny] = -1;
			nx = nx + deltas[d][0];
			ny = ny + deltas[d][1];
		}
	}
	
	public static int countZero(int[][] arr) {
		int count = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j]==0) count++;
			}
		}
		return count;
	}
}
