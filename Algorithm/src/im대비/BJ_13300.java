package im대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13300 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, K;
	static int[] man;
	static int[] woman;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		man = new int[7];
		woman = new int[7];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken())==0) {
				woman[Integer.parseInt(st.nextToken())]++;
			}else {
				man[Integer.parseInt(st.nextToken())]++;
			}
		}
		int sum=0;
		for(int i=1; i<7; i++) {
			sum += (woman[i]+K-1)/K;
			sum += (man[i]+K-1)/K;
		}
		System.out.println(sum);
	}
}
