package day1_rec_arr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_1244 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N;
	static int[] sw;
	static int S;
	static int gender;
	static int number;
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		sw = new int[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=N; i++) {
			sw[i] = Integer.parseInt(st.nextToken());
		}
		S = Integer.parseInt(br.readLine());
		
		for(int j=0; j<S; j++) {
			st = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st.nextToken());
			number = Integer.parseInt(st.nextToken());
			
			if(gender==1) {
				for(int i=1; i<=N; i++) {
					if(i%number==0) {
						sw[i] = change(sw[i]);
					}
				}
			}else {
				int idx_L = number-1;
				int idx_R = number+1;
				sw[number] = change(sw[number]);
				while(true) {
					if(idx_L<=0 || idx_R>N) break;
					
					if(sw[idx_L]==sw[idx_R]) {
						sw[idx_L] = change(sw[idx_L]);
						sw[idx_R] = change(sw[idx_R]);
					}
					else break;
					
					idx_L--;
					idx_R++;
				}
			}
		}
		printSW();
		bw.flush();
		bw.close();
	}
	
	public static int change(int n) {
		if(n==1) return 0;
		else return 1;
	}
	
	public static void printSW() throws IOException{
		int start = 1;
		int end = 20;
		
		outer: for(int i=0; i<5; i++) {
			for(int j=start; j<=end; j++) {
				if(j>N) break outer;
				bw.write(sw[j] + " ");
			}
			bw.write("\n");
			start+=20;
			end+=20;
		}
	}
}
