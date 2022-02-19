package day4_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2477 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N; // 참외 개수
	static int[][] field = new int[6][2];
	//육각형 밭
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<6; i++) {
			st = new StringTokenizer(br.readLine());
			field[i][0] = Integer.parseInt(st.nextToken());
			field[i][1] = Integer.parseInt(st.nextToken());
		}
		solve();
	}
	
	public static void solve() {
		int[] nextD = {0, 4, 3, 1, 2}; 
		int max_X=0;
		int max_Y=0;
		int min_X=0;
		int min_Y=0;
		
		for(int i=0; i<6; i++) {
			if(field[i][0]==1 || field[i][0]==2) {
				max_X = Math.max(max_X, field[i][1]);
			}
			if(field[i][0]==3 || field[i][0]==4) {
				max_Y = Math.max(max_Y, field[i][1]);
			}
			if(i==0) continue;
			if(nextD[field[i-1][0]]!=field[i][0]) {
				min_X=field[i-1][1];
				min_Y=field[i][1];
			}
		}
		if(min_X==0 && min_Y==0) {
			min_X=field[0][1];
			min_Y=field[5][1];
		}
		
		System.out.println(N*((max_X*max_Y)-(min_X*min_Y)));
	}
}
