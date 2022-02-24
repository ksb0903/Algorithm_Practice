package day10_SP_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BJ_1753 {
	static class Edge implements Comparable<Edge>{
		int num;
		int dist;
		
		public Edge(int num, int dist) {
			super();
			this.num = num;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.dist - o.dist;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int V, E, INF = Integer.MAX_VALUE;
	static ArrayList<ArrayList<Edge>> list = new ArrayList<>();
	static int[] distance;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int startNum = Integer.parseInt(br.readLine());
		distance = new int[V+1];
		Arrays.fill(distance, INF);
		
		for(int i=0; i<=V; i++) {
			list.add(new ArrayList<Edge>());
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			list.get(from).add(new Edge(to, dist));
		}
		
		dijkstra(startNum);
		
		for(int i=1; i<=V; i++) {
			if(i==startNum) System.out.println(0);
			else if(distance[i]==INF) System.out.println("INF");
			else System.out.println(distance[i]);
		}
	}
	
	public static void dijkstra(int start) {
		boolean[] visited = new boolean[V+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		distance[start] = 0;
		
		pq.offer(new Edge(start, 0));
		
		while(!pq.isEmpty()){
			Edge edge = pq.poll();
			
			if(visited[edge.num]) continue;
			visited[edge.num] = true;
			
			for(Edge e: list.get(edge.num)) {
				if(!visited[e.num] && e.dist!=0 && distance[e.num]>distance[edge.num]+e.dist) {
					distance[e.num] = distance[edge.num] + e.dist;
					pq.offer(new Edge(e.num, distance[e.num]));
				}
			}
		}
	}
}
