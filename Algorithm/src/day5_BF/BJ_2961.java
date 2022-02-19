package day5_BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2961 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, min=Integer.MAX_VALUE;
	static int[][] food;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		food = new int[N][2];
		isSelected = new boolean[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			food[i][0] = Integer.parseInt(st.nextToken());
			food[i][1] = Integer.parseInt(st.nextToken());
		}
		
		subset(0);
		
		System.out.println(min);
	}
	
	public static void subset(int cnt) {
		if(cnt==N) {
			int sour=1;
			int bitter=0;
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					sour *= food[i][0];
					bitter += food[i][1];
				}
			}
			if(sour!=1 && bitter!=0) {
				int dist = Math.abs(sour-bitter);
				min = Math.min(min, dist);
			}
			return;
		}
		
		isSelected[cnt] = true;
		subset(cnt+1);
		isSelected[cnt] = false;
		subset(cnt+1);
	}
}
