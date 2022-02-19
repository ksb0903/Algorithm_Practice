package day1_rec_arr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Harvest {
	static BufferedReader br;
	static BufferedWriter bw;
	static char[][] arr;
	static int T, N;
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[N][N];
			
			for(int r=0; r<N; r++) {
				arr[r] = br.readLine().toCharArray();
			}
			bw.write(String.format("#%d ", tc));
			bw.write(getValue() + "\n");
			bw.flush();
		}
		bw.close();
	}
	
	public static int getValue() {
		int sum=0;
		for(int i=0; i<N; i++) {
			if(i<=N/2) {
				for(int j=(N/2)-i; j<=(N/2)+i; j++) {
					sum+=(int)(arr[i][j]-'0');
				}
			}else {
				for(int j=(N/2)-(N-i-1); j<=(N/2)+(N-i-1); j++) {
					sum+=(int)(arr[i][j]-'0');
				}
			}
		}
		return sum;
	}
}
