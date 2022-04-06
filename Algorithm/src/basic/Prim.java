package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Prim {
	static class Edge implements Comparable<Edge>{
		int dist, next;

		public Edge(int dist, int next) {
			super();
			this.dist = dist;
			this.next = next;
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
		int[][] adjMatrix = new int[N][N];
		int[] minEdge = new int[N];
		boolean[] visited = new boolean[N];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		
		int result = 0;
		q.add(0);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			visited[now] = true;
			
			for(int i=0; i<N; i++) {
				if(visited[i]) continue;
				if(adjMatrix[now][i]>0) pq.add(new Edge(i, adjMatrix[now][i]));
			}
			
			while(!pq.isEmpty()) {
				Edge e = pq.poll();
				if(!visited[e.next]) {
					q.add(e.next);
					visited[e.next] = true;
					result += e.dist;
					break;
				}
			}
		}
		
		System.out.println(result);
	}
}
