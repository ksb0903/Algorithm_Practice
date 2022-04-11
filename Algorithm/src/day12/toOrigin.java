package day12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class toOrigin {
	static int N, dots[], max, ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			dots = new int[N];
			max = 0;
			ans = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Math.abs(Integer.parseInt(st.nextToken()));
				int b = Math.abs(Integer.parseInt(st.nextToken()));
				
				dots[i] = a+b;
				max = Math.max(max, a+b);
 			}
			
			for(int i=1; i<N; i++) {
				if(dots[i]%2 != dots[i-1]%2) {
					ans = -1;
					break;
				}
			}
			
			bw.write(String.format("#%d ", tc));
			if(ans!=-1) {
				ans = solve();
			}
			bw.write(ans + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static int solve() {
		int cnt = 0;
		int res = 0;
		
		while(true) {
			if(max<=cnt && (cnt-max)%2==0) return res;
			else{
				res++;
				cnt += res;
			}
		}
	}
}
