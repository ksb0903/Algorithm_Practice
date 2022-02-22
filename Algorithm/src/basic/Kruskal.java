package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Kruskal {
	static class Edge implements Comparable<Edge>{
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	static Edge[] edgeList;
	static int[] p;
	static int N;
	
	public static void makeSet() {
		p = new int[N];
		for(int i=0; i<N; i++) {
			p[i] = i;
		}
	}
	
	public static int findSet(int a) {
		if(a==p[a]) return a;
		return p[a] = findSet(p[a]);
	}
	
	public static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		
		p[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		edgeList = new Edge[E];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		}
		
		Arrays.sort(edgeList);
		makeSet();
		
		int result = 0, cnt = 0;
		
		for(Edge edge: edgeList) {
			if(unionSet(edge.start, edge.end)) {
				result += edge.weight;
				if(++cnt == N-1) break;
			}
		}
		
		System.out.println(result);
	}
}
