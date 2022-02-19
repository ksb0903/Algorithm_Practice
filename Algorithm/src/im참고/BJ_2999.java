package im참고;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_2999 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		String massage = br.readLine();
		int len = massage.length();
		int R=0;
		int C=0;
		outer: for(int r=len; r>=1; r--) {
			for(int c=len; c>=r; c--) {
				if(r*c==len) {
					R=r;
					C=c;
					break outer;
				}
			}
		}
		
		char[][] decoding = new char[R][C];
		int idx = 0;

		for(int j=0; j<C; j++) {
			for(int i=0; i<R; i++) {
				decoding[i][j] = massage.charAt(idx);
				idx++;
			}
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				bw.write(decoding[i][j]);
			}
		}
		
		bw.flush();
		bw.close();
	}
}
