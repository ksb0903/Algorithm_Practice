package day1_rec_arr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class HW02 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int[][] map;
	static int T, N, M;
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bw.write(String.format("#%d ", tc));
			bw.write(getMax() + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static int getMax() {
		int max=0;
		
		for(int i=0; i<=N-M; i++) {
			for(int j=0; j<=N-M; j++) {
				int sum=0;
				for(int r=i; r<i+M; r++) {
					for(int c=j; c<j+M; c++) {
						sum+=map[r][c];
					}
					max = max>sum? max: sum;
				}
			}
		}
		
		return max;
	}
}
