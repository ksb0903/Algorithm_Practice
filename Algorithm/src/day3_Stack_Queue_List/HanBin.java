package day3_Stack_Queue_List;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class HanBin {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int T, N, M, max;
	static int[] snack;
	
	public static void main(String[] args) throws IOException{
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			bw.write(String.format("#%d ", tc));
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			snack = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			max=-1;
			comb(0, 0, 0);
			bw.write(max+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void comb(int cnt, int start, int w) {
		if(cnt==2) {
			if(w<=M)
				max = max>w? max: w;

			return;
		}
		
		for(int i=start; i<N; i++) {
			comb(cnt+1, i+1, w+snack[i]);
		}
	}
}
