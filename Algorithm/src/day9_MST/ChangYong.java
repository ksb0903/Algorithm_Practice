package day9_MST;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ChangYong {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int T, N, M;
	static int p[];
	
	public static void main(String[] args) throws IOException{
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			bw.write(String.format("#%d ", tc));
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			makeSet();
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				unionSet(a, b);
			}
			
			int cnt=1;
			for(int i=1; i<=N; i++) {
				p[i] = findSet(i);
			}
			
			Arrays.sort(p);
			for(int i=2; i<=N; i++) {
				if(p[i-1]!=p[i]) cnt++;
			}
			bw.write(cnt+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void makeSet() {
		p = new int[N+1];
		for(int i=1; i<=N; i++) {
			p[i] = i;
		}
	}
	
	public static int findSet(int x) {
		if(x == p[x]) return x;
		else return p[x] = findSet(p[x]);
	}
	
	public static void unionSet(int a, int b) {
		if(findSet(a)==findSet(b)) return;
		p[findSet(b)] = findSet(a);
	}
}
