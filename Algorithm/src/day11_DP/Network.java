package day11_DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Network {
	static int T, N, graph[][];
	static final int INF = 1000000;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			bw.write(String.format("#%d ", tc));
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			graph = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int x = Integer.parseInt(st.nextToken());
					if(i==j) graph[i][j] = 0;
					else if(x==0) graph[i][j] = INF;
					else if(x==1) graph[i][j] = 1;
				}
			}
			
			floyd();
			bw.write(getAns() + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static int getAns() {
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			int sum = 0;
			for(int j=0; j<N; j++) {
				if(graph[i][j]==INF) continue;
				
				sum += graph[i][j];
			}
			
			min = Math.min(min, sum);
		}
		
		return min;
	}
	
	public static void floyd() {
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
	}
}
