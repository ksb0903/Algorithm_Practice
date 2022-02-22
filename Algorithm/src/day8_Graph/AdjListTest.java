package day8_Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AdjListTest {
	static class Node{
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
	}
	
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int C = sc.nextInt();
		
		Node[] adjList = new Node[N];
		for(int i=0; i<C; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
		
		/*for(Node head: adjList) {
			System.out.println(head);
		}*/
		bfs(0, adjList);
		System.out.println();
		dfs(adjList, new boolean[N], 0);
	}
	
	public static void bfs(int start, Node[] adjList) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N];
		
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print((char)(current+65));
			
			for(Node tmp=adjList[current]; tmp!=null; tmp=tmp.link) {
				if(!visited[tmp.vertex]) {
					queue.offer(tmp.vertex);
					visited[tmp.vertex] = true;
				}
			}
		}
	}
	
	public static void dfs(Node[] adjList, boolean[] visited, int current) {
		visited[current] = true;
		System.out.print((char)(current+65));
		
		for(Node tmp=adjList[current]; tmp!=null; tmp=tmp.link) {
			if(!visited[tmp.vertex]) {
				dfs(adjList, visited, tmp.vertex);
			}
		}
	}
}
