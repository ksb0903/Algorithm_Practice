package day9_MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PrimByPq {
	static class Edge implements Comparable<Edge>{
		int nodeNum;
		int dist;
		
		public Edge(int nodeNum, int dist) {
			this.nodeNum = nodeNum;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.dist - o.dist;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		boolean[] visited = new boolean[N];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int[][] adjMatrix = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		pq.offer(new Edge(0,0));
		
		int result = 0, cnt = 0;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			if(visited[edge.nodeNum]) continue;
			visited[edge.nodeNum] = true;
			result += edge.dist;
			
			for(int i=0; i<N; i++) {
				if(!visited[i]&&adjMatrix[edge.nodeNum][i]>0) {
					pq.add(new Edge(i, adjMatrix[edge.nodeNum][i]));
				}
			}
			if(++cnt==N) break;
		}
		System.out.println(result);
	}
}
