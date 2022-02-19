package im참고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2798 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, nearest=0;
	static int[] card, selected;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		card = new int[N];
		selected = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		comb(0, 0);
		System.out.println(nearest);
	}
	
	public static void comb(int cnt, int start) {
		if(cnt==3) {
			int sum = 0;
			for(int i=0; i<3; i++) {
				sum += selected[i];
			}
			
			if(sum<=M) {
				nearest = Math.max(nearest, sum);
			}
			
			return;
		}
		
		for(int i=start; i<N; i++) {
			selected[cnt] = card[i];
			comb(cnt+1, i+1);
		}
	}
}
