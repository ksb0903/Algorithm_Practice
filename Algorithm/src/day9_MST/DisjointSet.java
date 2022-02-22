package day9_MST;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class DisjointSet {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int T, N, M;
	static int[] p;
	
	public static void main(String[] args) throws IOException{
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			bw.write(String.format("#%d ", tc));
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			p = new int[N+1];
			
			for(int i=1; i<=N; i++) {
				p[i] = i; // make set
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int cmd = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(cmd==0) {
					UnionSet(a, b);
				}else if(cmd==1) {
					if(findSet(a)==findSet(b)) {
						bw.write("1");
					}else {
						bw.write("0");
					}
				}
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static int findSet(int x) {
		if(p[x]==x) return x;
		else return p[x] = findSet(p[x]);
	}
	
	public static void UnionSet(int a, int b) {
		if(findSet(a)==findSet(b)) return;
		else {
			p[findSet(b)] = findSet(a);
		}
	}
}
