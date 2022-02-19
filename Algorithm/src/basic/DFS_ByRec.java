package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFS_ByRec {
	static int[][] map;
	static boolean[] visited;
	static StringTokenizer st;
	static int N, M, start, end;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			map[start][end] = 1;
			map[end][start] = 1;
		}
		System.out.print("그래프 DFS 방문 순서: ");
		dfs(1);
	}
	
	static void dfs(int point) {
		visited[point] = true;
		System.out.print(point + " ");
			
		for(int i=1; i<=N; i++) {
			if(map[point][i]==1 && visited[i]==false) {
					dfs(i);
			}
		}
	}
}
