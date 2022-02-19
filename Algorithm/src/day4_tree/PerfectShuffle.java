package day4_tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PerfectShuffle {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int T, N;
	static String[] S;
	
	public static void main(String[] args) throws IOException{
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			bw.write(String.format("#%d ", tc));
			N = Integer.parseInt(br.readLine());
			S = new String[N];
			S = br.readLine().split(" ");
			shuffle();
		}
		bw.flush();
		bw.close();
	}
	
	public static void shuffle() throws IOException{
		for(int i=0; i<N/2; i++) {
			bw.write(S[i] + " ");
			bw.write(S[(N+1)/2+i] + " ");
		}
		if(N%2==1) bw.write(S[N/2]);
		
		bw.write("\n");
	}
}
