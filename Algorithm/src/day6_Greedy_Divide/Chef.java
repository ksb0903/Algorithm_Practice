package day6_Greedy_Divide;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Chef {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int T, N, min;
	static int[][] synergy;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException{
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			bw.write(String.format("#%d ", tc));
			N = Integer.parseInt(br.readLine());
			synergy = new int[N][N];
			isSelected = new boolean[N];
			min = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			comb(0,0);
			bw.write(min+"\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void comb(int cnt, int start) {
		if(cnt==N/2) {
			int foodA = getFavor(true);
			int foodB = getFavor(false);
			min = Math.min(min, Math.abs(foodA-foodB));
			return;
		}
		
		for(int i=start; i<N; i++) {
			isSelected[i] = true;
			comb(cnt+1, i+1);
			isSelected[i] = false;
		}
	}
	
	public static int getFavor(boolean flag) {
		int sum = 0;
		
		for(int i=0; i<N-1; i++) {
			if(isSelected[i]!=flag) continue;
			for(int j=i+1; j<N; j++) {
				if(isSelected[j]==flag) {
					sum += synergy[i][j];
					sum += synergy[j][i];
				}
			}
		}
		
		return sum;
	}
}
