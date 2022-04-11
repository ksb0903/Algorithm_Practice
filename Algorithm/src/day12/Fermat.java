package day12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Fermat {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, R;
	static final long mod = 1234567891;
	
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			bw.write(String.format("#%d ", tc));
			bw.write(ncr(N, R, mod) + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static long ncr(int n, int r, long p) {
		if(r==0) return 1L;
		
		long[] fac = new long[n+1];
		fac[0] = 1;
		
		for(int i=1; i<=n; i++) {
			fac[i] = fac[i-1]*i%p;
		}
		
		return (fac[n] * power(fac[r], p-2, p)%p * power(fac[n-r], p-2, p)%p)%p;
	}
	
	public static long power(long x, long y, long p) {
		long res = 1L;
		while(y>0) {
			if(y%2==1) res = (res*x)%p;
			
			y = y>>1;
			x = (x*x)%p;
		}
		
		return res;
	}
}
