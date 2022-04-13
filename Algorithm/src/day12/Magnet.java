package day12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Magnet {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int K;
	static int[][] magnet;
	
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			bw.write(String.format("#%d ", tc));
			
			K = Integer.parseInt(br.readLine());
			magnet = new int[4][8];
			for(int i=0; i<4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken())-1;
				int dir = Integer.parseInt(st.nextToken());
				
				rotateOP(num, dir);
			}
			
			int res = 0;
			for(int i=0; i<4; i++) {
				if(magnet[i][0]==1) {
					res += Math.pow(2, i);
				}
			}
			bw.write(res+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void rotateOP(int num, int dir) {
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[5];
		q.offer(new int[] {num, dir});
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int n = poll[0];
			int d = poll[1];
			if(visited[n]) continue;
			visited[n] = true;
			
			if(n==0) {
				if(magnet[0][2]!=magnet[1][6]) {
					q.offer(new int[] {1, -d});
				}
			}else if(n==3) {
				if(magnet[3][6]!=magnet[2][2]) {
					q.offer(new int[] {2, -d});
				}
			}else {
				if(magnet[n][2]!=magnet[n+1][6]) {
					q.offer(new int[] {n+1, -d});
				}
				
				if(magnet[n][6]!=magnet[n-1][2]) {
					q.offer(new int[] {n-1, -d});
				}
			}
			
			rotate(n, d);
		}
	}
	
	public static void rotate(int num, int dir) {
		if(dir==1) {
			int tmp = magnet[num][7];
			for(int i=7; i>0; i--) {
				magnet[num][i] = magnet[num][i-1];
			}
			magnet[num][0] = tmp;
		}else {
			int tmp = magnet[num][0];
			for(int i=0; i<7; i++) {
				magnet[num][i] = magnet[num][i+1];
			}
			magnet[num][7] = tmp;
		}
	}
}
