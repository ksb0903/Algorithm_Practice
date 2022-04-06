package day11_DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BlockBreaking {
	static int N, W, H, min, map[][];
	
	static class Block{
		int x, y, range;

		public Block(int x, int y, int range) {
			super();
			this.x = x;
			this.y = y;
			this.range = range;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			bw.write(String.format("#%d ", tc));
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				} 
			}
			min = Integer.MAX_VALUE;
			dfs(0, map);
			bw.write(min + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int cnt, int[][] arr) {
		if(cnt==N) {
			min = Math.min(min, count(arr));
			
			return;
		}
		
		int[][] clone = new int[H][W];
		for(int i=0; i<H; i++) {
			clone[i] = arr[i].clone();
		}
		
		for(int j=0; j<W; j++) {
			remove(clone, j);
			organize(clone);
			dfs(cnt+1, clone);
			
			for(int i=0; i<H; i++) {
				clone[i] = arr[i].clone();
			}
		}
	}
	
	
	public static int count(int[][] arr) {
		int cnt = 0;
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(arr[i][j]!=0) cnt++;
			}
		}
		
		return cnt;
	}
	
	public static int[][] organize(int[][] arr) {
		for(int j=0; j<W; j++) {
			for(int i=H-1; i>=0; i--) {
				if(arr[i][j]!=0) {
					int ni = i+1;
					while(true) {
						if(ni>=H || arr[ni][j]!=0) break;
						arr[ni][j] = arr[ni-1][j];
						arr[ni-1][j] = 0;
						ni++;
					}
				}
			}
		}
		
		return arr;
	}
	
	public static int[][] remove(int[][] arr, int col){
		Queue<Block> q = new LinkedList<>();
		int deltas[][] = {{0,1},{1,0},{0,-1},{-1,0}};
		
		for(int i=0; i<H; i++) {
			if(arr[i][col]>0) {
				q.add(new Block(i, col, arr[i][col]));
				arr[i][col] = 0;
				break;
			}
		}
		
		while(!q.isEmpty()) {
			Block b = q.poll();
			int x = b.x;
			int y = b.y;
			int range = b.range;
			
			for(int i=1; i<range; i++) {
				for(int d=0; d<4; d++) {
					int nx = x + (deltas[d][0] * i);
					int ny = y + (deltas[d][1] * i);
					
					if(nx>=0 && ny>=0 && nx<H && ny<W && arr[nx][ny]!=0) {
						q.offer(new Block(nx, ny, arr[nx][ny]));
						arr[nx][ny] = 0;
					}
				}
			}
		}
		
		return arr;
	}
}
