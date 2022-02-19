package day7_BackT_Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Best_Route {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int T, N, min;
	static int[] company, home, sequence;
	static int[][] customers, distance;
	
	public static void main(String[] args) throws IOException{
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			bw.write(String.format("#%d ", tc));
			N = Integer.parseInt(br.readLine());
			customers = new int[N][2];
			sequence = new int[N];
			distance = new int[N+2][N+2];
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			company = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			home = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			for(int i=0; i<N; i++) {
				customers[i][0] = Integer.parseInt(st.nextToken());
				customers[i][1] = Integer.parseInt(st.nextToken());
				sequence[i] = i;
			}
			getDist();
			do {
				getRoute(company, home);
			}while(np());
			bw.write(min+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void getDist() {
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				distance[i][j] = Math.abs(customers[i][0]-customers[j][0]) + Math.abs(customers[i][1]-customers[j][1]);
				distance[j][i] = distance[i][j];
			}
		}
		
		for(int i=0; i<N; i++) {
			distance[i][N] = Math.abs(customers[i][0]-company[0]) + Math.abs(customers[i][1]-company[1]);
			distance[N][i] = distance[i][N];
			
			distance[i][N+1] = Math.abs(customers[i][0]-home[0]) + Math.abs(customers[i][1]-home[1]);
			distance[N+1][i] = distance[N+1][i];
		}
	}
	
	public static boolean np() {
		int i = N-1;
		while(i>0 && sequence[i-1]>=sequence[i]) --i;
		if(i==0) return false;
		
		int j = N-1;
		while(sequence[i-1]>=sequence[j]) --j;
		
		swap(i-1, j);
		int k = N-1;
		while(i<k) {
			swap(i++, k--);
		}
		return true;
	}
	
	public static void swap(int i, int j) {
		int tmp = sequence[i];
		sequence[i] = sequence[j];
		sequence[j] = tmp;
	}
	
	public static void getRoute(int[] from, int[] to) {
		int dist = distance[N][sequence[0]];
		
		for(int i=1; i<N; i++) {
			dist += distance[sequence[i-1]][sequence[i]];
		}
		
		dist += distance[sequence[N-1]][N+1];
		
		if(dist<min) min = dist;
	}
}
