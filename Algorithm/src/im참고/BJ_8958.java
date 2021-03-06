package im참고;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_8958 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			int sum = 0;
			int score = 1;
			for(int j=0, len=s.length(); j<len; j++) {
				if(s.charAt(j)=='O') {
					sum += score++;
				}else {
					score = 1;
				}
			}
			bw.write(sum+"\n");
		}
		
		bw.flush();
		bw.close();
	}
}
