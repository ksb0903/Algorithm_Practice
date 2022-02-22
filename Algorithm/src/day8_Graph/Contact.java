package day8_Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Contact {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static boolean[] visited;
	static int[][] people;
	static int N, start, max, levels[];
	
	public static void main(String[] args) throws IOException{
		for(int tc=1; tc<=10; tc++) {
			bw.write(String.format("#%d ", tc));
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			people = new int[101][101];
			visited = new boolean[101];
			max = 0;
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				people[from][to] = 1;
			}
			
			bfs(start, visited);
			for(int i=0; i<levels.length; i++) {
				if(levels[i]==0) {
					max = levels[i-1];
					break;
				}
			}
			bw.write(max+"\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void bfs(int start, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visited[start] = true;
		levels = new int[N/2];
		int level = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int s=0; s<size; s++) {
				int current = queue.poll();
				
				for(int i=1; i<100; i++) {
					if(!visited[i] && people[current][i]==1) {
						visited[i] = true;
						queue.offer(i);
						levels[level] = Math.max(levels[level], i);
					}
				}
			}
			level++;
		}
	}
	
}
