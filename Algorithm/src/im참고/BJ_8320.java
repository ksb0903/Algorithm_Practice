package im참고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_8320 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		int count=0;
		for(int i=1; i<=N; i++) {
			for(int j=i; j<=N; j++) {
				if(i*j<=N) count++;
			}
		}
		System.out.println(count);
	}
}
