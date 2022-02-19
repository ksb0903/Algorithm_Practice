package im대비;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_10163 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static int[][] plane;
	static int[] papers;
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		plane = new int[1001][1001];
		papers = new int[N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			
			for(int r=x; r<x+width; r++) {
				for(int c=y; c<y+height; c++) {
					plane[r][c] = i;
				}
			}
		}
		
		for(int i=0; i<1001; i++) {
			for(int j=0; j<1001; j++) {
				if(plane[i][j]>0) {
					papers[plane[i][j]]++;
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			bw.write(papers[i]+"\n");
		}
		bw.flush();
		bw.close();
	}
}
