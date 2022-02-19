package day6_Greedy_Divide;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_1992 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static char[][] arr;
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		solve(0,0,N);
		bw.flush();
		bw.close();
	}
	
	public static void solve(int x, int y, int n) throws IOException{
		char c = arr[x][y];
		boolean flag = true;
		
		outer: for(int i=x; i<x+n; i++) {
			for(int j=y; j<y+n; j++) {
				if(arr[i][j]!=c) {
					bw.write("(");
					solve(x, y, n/2);
					solve(x, y+n/2, n/2);
					solve(x+n/2, y, n/2);
					solve(x+n/2, y+n/2, n/2);
					bw.write(")");
					flag = false;
					break outer;
				}
			}
		}
		
		if(flag) {
			if(c=='0') bw.write('0');
			else bw.write('1');
		}
	}
}
