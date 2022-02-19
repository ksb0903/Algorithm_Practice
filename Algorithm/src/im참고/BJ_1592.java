package im참고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1592 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, L;
	static int[] people;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		people = new int[N];
		people[0] = 1;
		int now = 0;
		int count = 0;
		
		while(true) {
			if(people[now]%2==0) {
				if(now<L) now = N+now-L;
				else now = now-L;
			}else {
				if(now+L>=N) now = now+L-N;
				else now = now+L;
			}
			people[now]++;
			count++;
			if(people[now]==M) break;
		}
		if(M==1) System.out.println(0);
		else System.out.println(count);
	}
}
