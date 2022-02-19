package im대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2559 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, K, max;
	static int[] temps;
	static int[] sums;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		temps = new int[N];
		sums = new int[N-K+1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			temps[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<K; i++) {
			sums[0] += temps[i];
		}
		max = sums[0];
		for(int i=1; i<=N-K; i++) {
			sums[i] = sums[i-1]-temps[i-1]+temps[K+i-1];
			max = Math.max(max, sums[i]);
		}
		System.out.println(max);
	}
}
