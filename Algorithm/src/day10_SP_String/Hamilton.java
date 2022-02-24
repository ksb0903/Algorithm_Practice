package day10_SP_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hamilton {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, min;
	static int[][] Matrix;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		Matrix = new int[N][N];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				Matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		visited[0] = true;
		getRoute(0, 0, 0);
		System.out.println(min);
	}
	
	public static void getRoute(int to, int cnt, int cost) {
		if(cnt==N-1) {
			if(Matrix[to][0]==0) return;
			
			min = Math.min(min, cost+Matrix[to][0]);
			
			return;
		}
		
		for(int i=1; i<N; i++) {
			if(visited[i] || Matrix[to][i]==0) continue;
			
			if(cost + Matrix[to][i] > min) continue;
			visited[i] = true;
			getRoute(i, cnt+1, cost+Matrix[to][i]);
			visited[i] = false;
		}
	}
	
}
