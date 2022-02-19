package day3_Stack_Queue_List;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_16926 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, M, R;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<R; i++) {
			rotate();
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				bw.write(arr[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void rotate() {
		int[][] deltas = {{1,0},{0,1},{-1,0},{0,-1}}; 
		int min = Math.min(N, M)/2;
		int[][] copy = new int[N+1][M+1];
		
		for(int i=1; i<=min; i++) {
			int x=i;
			int y=i;
			int idx=0;
			
			while(idx<4) {
				int nx = x+deltas[idx][0];
				int ny = y+deltas[idx][1];
				
				if(nx<=N-i+1 && ny<=M-i+1 && nx>=i && ny>=i) {
					copy[nx][ny] = arr[x][y];
					x = nx;
					y = ny;
				}else idx++;
			}
		}
		System.arraycopy(copy, 0, arr, 0, copy.length);
	}
}
