package im참고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3985 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int L, N;
	static int[] cake;
	
	public static void main(String[] args) throws IOException{
		L = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		int expect = 0;
		int e_idx=0;
		int real = 0;
		int r_idx=0;
		cake = new int[L+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int count = 0;
			
			if(expect<(k-p)) {
				expect = k-p;
				e_idx = i;
			}
			
			for(int j=p; j<=k; j++) {
				if(cake[j]==0) {
					cake[j] = i;
					count++;
				}
			}
			
			if(real<count) {
				real = count;
				r_idx = i;
			}
		}
		
		System.out.println(e_idx);
		System.out.println(r_idx);
	}
}
